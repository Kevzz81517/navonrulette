package com.navonmesh.navonrulette.service;

import com.navonmesh.navonrulette.configuration.DefaultRuleConfiguration;
import com.navonmesh.navonrulette.configuration.IdentificationType;
import com.navonmesh.navonrulette.exception.ApplicationException;
import com.navonmesh.navonrulette.rule.*;
import com.navonmesh.navonrulette.rule.type.AlertSeverityType;
import com.navonmesh.navonrulette.rule.type.RuleType;
import com.navonmesh.navonrulette.rule.type.SignalCriticalityType;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.command.Command;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

import org.appformer.maven.integration.DefaultArtifactResolver;

@Service
public class VendorServiceImpl {

    @Value("${rule.change.scanner.time.millis}")
    private long ruleChangeScannerTiming;


    private final Map<String, KieContainer> KIE_CONTAINERS = new ConcurrentHashMap<>();

    public static final Map<String, ExternalRepositoryInfo> EXTERNAL_REPOSITORIES = new ConcurrentHashMap<>();


    public KieContainer addTenantKieContainer(String institutionPackage, String artifact, String version, String url, String username, String password) {
        String tenantId = institutionPackage + "." + artifact;
        if (KIE_CONTAINERS.containsKey(tenantId)) {
            throw new ApplicationException("Already Exists");
        } else {
            EXTERNAL_REPOSITORIES.put(
                    tenantId,
                    ExternalRepositoryInfo.builder().url(url)
                            .username(username)
                            .password(password)
                            .build()
            );

            KieServices ks = KieServices.Factory.get();
            ReleaseId releaseId = ks.newReleaseId(institutionPackage, artifact, version);
            ks.getRepository().addKieModule(
                    ks.getResources()
                            .newFileSystemResource(
                                    new DefaultArtifactResolver()
                                            .resolveArtifact(releaseId).getFile()
                            )
            );

            KieContainer kieContainer = ks.newKieContainer(releaseId);
            KieScanner kieScanner = ks.newKieScanner(kieContainer);
            kieScanner.start(ruleChangeScannerTiming);
            KIE_CONTAINERS.put(tenantId, kieContainer);
            return kieContainer;
        }
    }

    public KieContainer getTenantKieContainer(String tenantId) {

        KieContainer kieContainer = KIE_CONTAINERS.get(tenantId);
        if (kieContainer != null) {

            return kieContainer;

        } else {

            throw new ApplicationException(tenantId + " Doesn't Exists");
        }
    }

    private InputStream urlToInputStream(URL url, Map<String, String> args) {
        HttpURLConnection con = null;
        InputStream inputStream = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            if (args != null) {
                for (Map.Entry<String, String> e : args.entrySet()) {
                    con.setRequestProperty(e.getKey(), e.getValue());
                }
            }
            con.connect();
            int responseCode = con.getResponseCode();
            /* By default the connection will follow redirects. The following
             * block is only entered if the implementation of HttpURLConnection
             * does not perform the redirect. The exact behavior depends to
             * the actual implementation (e.g. sun.net).
             * !!! Attention: This block allows the connection to
             * switch protocols (e.g. HTTP to HTTPS), which is <b>not</b>
             * default behavior. See: https://stackoverflow.com/questions/1884230
             * for more info!!!
             */
            if (responseCode < 400 && responseCode > 299) {
                String redirectUrl = con.getHeaderField("Location");
                try {
                    URL newUrl = new URL(redirectUrl);
                    return urlToInputStream(newUrl, args);
                } catch (MalformedURLException e) {
                    URL newUrl = new URL(url.getProtocol() + "://" + url.getHost() + redirectUrl);
                    return urlToInputStream(newUrl, args);
                }
            }
            /*!!!!!*/

            inputStream = con.getInputStream();
            return inputStream;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<RuleEntity> processRequest(String institutionPackage, String agenda, List<Object> datapoints) {
        StatelessKieSession kieSession = getTenantKieContainer(institutionPackage + "." + agenda).newStatelessKieSession();
        Map<String, Map<String, Object>> ruleData = new HashMap<>();
        List<Command> commands = new ArrayList<>();
        datapoints.forEach(datapoint -> commands.add(CommandFactory.newInsert(datapoint)));
        commands.add(new FireAllRulesCommand(match -> match.getRule().getPackageName().equals(institutionPackage + "." + agenda.toLowerCase())));
        commands.add(CommandFactory.newGetObjects("results"));

        kieSession.addEventListener(new DefaultAgendaEventListener() {

            @Override
            public void afterMatchFired(AfterMatchFiredEvent afterMatchFiredEvent) {

                Map<String, Object> metaData =
                        new HashMap<>(afterMatchFiredEvent.getMatch().getRule().getMetaData());
                metaData.put("InvolvedObjects", afterMatchFiredEvent.getMatch().getObjects());

                String name = afterMatchFiredEvent.getMatch().getRule().getName().replaceAll("_[0-9]+", "");
                ruleData.put(name, metaData);
            }
        });

        ExecutionResults rulesResults = kieSession.execute(CommandFactory.newBatchExecution(commands));


        Collection<Object> results = (Collection<Object>) rulesResults.getValue("results");

        List<RuleEntity> ruleEntities = new ArrayList<>();

        results.stream()
                .filter(result -> result instanceof RuleResponse)
                .forEach(result -> {

                    RuleResponse res = ((RuleResponse) result);

                    String ruleName = res.getRuleName().replaceAll("_[0-9]+", "");

                    Map<String, Object> meta = ruleData.get(ruleName);

                    String reference = (String) meta.get("Reference");

                    RuleType ruleType = RuleType.valueOf(((String) meta.get("RuleType")));

                    RuleEntity ruleEntity = null;

                    String supportedDescription = (String) meta.get("SupportingDescription");

                    switch (ruleType) {
                        case SIGNAL: {

                            List<String> supportingCategories = meta.get("SupportingCategories") != null ?
                                    Arrays.asList(((String) meta.get("SupportingCategories")).split(",")) : Collections.emptyList();
                            Set<String> dataSources = new HashSet<>();
                            Calendar maxDatasourceDate = null;

                            for (Object object : ((List<Object>) meta.get("InvolvedObjects"))) {

                                List<Object> items = null;

                                if (object instanceof List) {
                                    items = ((List) object);
                                } else {
                                    items = Collections.singletonList(object);
                                }

                                for (Object o : items) {

                                    if (o instanceof FactEntityV1) {
                                        IdentificationType identificationType =
                                                DefaultRuleConfiguration.getIdentificationTypeFromFactEntityRuleClass(o.getClass());
                                        dataSources.add(identificationType.name());

                                        try {
                                            Field entitiesField = o.getClass().getDeclaredField("entities");
                                            entitiesField.setAccessible(true);
                                            List<Object> entityObjects = (List<Object>) entitiesField.get(o);
                                            for (Object entityObject : entityObjects) {
                                                Field datasourceDateField = entityObject.getClass().getDeclaredField("datasourceDate");
                                                datasourceDateField.setAccessible(true);
                                                Calendar calendar = (Calendar) datasourceDateField.get(entityObject);
                                                if (maxDatasourceDate != null) {
                                                    if (maxDatasourceDate.compareTo(calendar) < 0) {
                                                        maxDatasourceDate = calendar;
                                                    }
                                                } else {
                                                    maxDatasourceDate = calendar;
                                                }
                                            }
                                        } catch (IllegalAccessException | NoSuchFieldException e) {
                                            throw new RuntimeException(e);
                                        }

                                    }
                                }
                            }

                            Calendar datasourceDate = (Calendar) maxDatasourceDate.clone();

                            List<String> supportingTags = null;
                            String tags = (String) meta.get("SupportingTags");
                            if (tags != null) {
                                supportingTags = new ArrayList<>(Arrays.asList(tags.split(",")));
                            }
                            Object thresholdMeta = meta.get("AlertThreshold");
                            Double threshold = thresholdMeta != null ? Double.parseDouble(String.valueOf(thresholdMeta)) : null;
                            SignalCriticalityType signalCriticality = SignalCriticalityType.valueOf((String) meta.get("Criticality"));
                            double weightage = signalCriticality.getWeightage();
                            ruleEntity = new SignalRuleEntity(reference, ruleType,
                                    ((NumericRuleResponse) res).getValue(), ruleName, supportingCategories, supportingTags,
                                    datasourceDate, new ArrayList<>(dataSources), weightage,
                                    threshold, ((NumericRuleResponse) res).getSupportingValues(), supportedDescription,
                                    signalCriticality.getAlertSeverity());
                            break;
                        }
                        case RISK_SCORE: {

                            Object thresholdMeta = meta.get("AlertThreshold");
                            List<String> supportingTags = null;
                            String tags = (String) meta.get("SupportingTags");
                            if (tags != null) {
                                supportingTags = new ArrayList<>(Arrays.asList(tags.split(",")));
                            }
                            AlertSeverityType alertSeverity = AlertSeverityType.valueOf((String) Objects.requireNonNull(meta.get("AlertSeverity")));
                            Double threshold = thresholdMeta != null ? Double.parseDouble(String.valueOf(thresholdMeta)) : null;
                            ruleEntity = new EwsScoreRuleEntity(reference, ruleType,
                                    ((NumericRuleResponse) res).getValue(), ruleName, threshold, supportingTags,
                                    ((NumericRuleResponse) res).getSupportingValues(), supportedDescription,
                                    alertSeverity);
                            break;
                        }
                        case CATEGORY: {

                            double weightage = Double.parseDouble(String.valueOf(meta.get("Weightage")));
                            List<String> supportingTags = null;
                            String tags = (String) meta.get("SupportingTags");
                            if (tags != null) {
                                supportingTags = new ArrayList<>(Arrays.asList(tags.split(",")));
                            }
                            Object thresholdMeta = meta.get("AlertThreshold");
                            AlertSeverityType alertSeverity = AlertSeverityType.valueOf((String) Objects.requireNonNull(meta.get("AlertSeverity")));
                            Double threshold = thresholdMeta != null ? Double.parseDouble(String.valueOf(thresholdMeta)) : null;
                            Map<RuleType, List<String>> affectingReferences = new HashMap<>();
                            AtomicReference<Calendar> maxDatasourceDate = new AtomicReference<>(null);
                            ((List<Object>) meta.get("InvolvedObjects")).forEach(object -> {

                                List<Object> items = null;

                                if (object instanceof List) {
                                    items = ((List) object);
                                } else {
                                    items = Collections.singletonList(object);
                                }

                                items.forEach(o -> {
                                    if (o instanceof RuleEntity) {
                                        RuleEntity affectingRuleEntity = (RuleEntity) o;
                                        List<String> refs = affectingReferences.getOrDefault(affectingRuleEntity.getRuleType(), new ArrayList<>());
                                        refs.add(affectingRuleEntity.getReference());
                                        affectingReferences.put(affectingRuleEntity.getRuleType(), refs);
                                    }
                                    if (o instanceof SignalRuleEntity) {
                                        if (maxDatasourceDate.get() != null) {
                                            if (maxDatasourceDate.get().compareTo(((SignalRuleEntity) o).getDatasourceDate()) < 0) {
                                                maxDatasourceDate.set(((SignalRuleEntity) o).getDatasourceDate());
                                            }
                                        } else {
                                            maxDatasourceDate.set(((SignalRuleEntity) o).getDatasourceDate());
                                        }
                                    }
                                });
                            });

                            Calendar maxDatasourceDateClone = (Calendar) maxDatasourceDate.get().clone();

                            ruleEntity = new CategoryRuleEntity(reference, ruleType,
                                    ((NumericRuleResponse) res).getValue(), ruleName, affectingReferences, weightage, supportingTags, maxDatasourceDateClone,
                                    threshold, ((NumericRuleResponse) res).getSupportingValues(), supportedDescription,
                                    alertSeverity);
                            break;
                        }
                        case ALERT: {
                            if (result instanceof SimpleAlertRuleResponse) {
                                List<String> supportingTags = null;
                                String tags = (String) meta.get("SupportingTags");
                                if (tags != null) {
                                    supportingTags = new ArrayList<>(Arrays.asList(tags.split(",")));
                                }
                                ruleEntity = new SimpleAlertRuleEntity(reference, ruleType, ruleName, supportingTags);
                            } else if (result instanceof ScoreEntityThresholdBasedAlertRuleResponse) {
                                ruleEntity = new ScoreEntityThresholdBasedAlertRuleEntity(reference, ruleType, ruleName, ((ScoreEntityThresholdBasedAlertRuleResponse) result).getNumericRuleEntity());
                            }
                            break;
                        }
                    }
                    ruleEntities.add(ruleEntity);
                });

        return ruleEntities;
    }


}
