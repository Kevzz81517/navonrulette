package com.navonmesh.navonrulette.controller;

import com.navonmesh.navonrulette.model.Datapoint;
import com.navonmesh.navonrulette.model.request.ProcessRequest;
import com.navonmesh.navonrulette.configuration.DatapointRuleConfiguration;
import com.navonmesh.navonrulette.configuration.DefaultRuleConfiguration;
import com.navonmesh.navonrulette.configuration.constant.DataFormatConstant;
import com.navonmesh.navonrulette.configuration.type.IdentificationType;
import com.navonmesh.navonrulette.configuration.util.DateFormattingUtility;
import com.navonmesh.navonrulette.exception.ApplicationException;
import com.navonmesh.navonrulette.rule.*;
import com.navonmesh.navonrulette.rule.type.DataAttributeType;
import com.navonmesh.navonrulette.rule.type.RuleType;
import com.navonmesh.navonrulette.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@RestController("MainController")
public class MainController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/data/process")
    public ResponseEntity<Map<RuleType, ? extends List<?>>> process(@RequestBody ProcessRequest processRequest) {
        String[] tenantIdparts = processRequest.getTenantId().split("\\.");
        String artifact = tenantIdparts[tenantIdparts.length - 1];
        String institutionPackage = String.join(".", Arrays.asList(tenantIdparts).subList(0, tenantIdparts.length - 1));
        Map<IdentificationType, List<Datapoint>> datapoints = processRequest.getDataEntities().stream().flatMap(reqObj -> reqObj.getData().stream()
                .map(reqObjPart -> new Datapoint(
                        reqObj.getIdentificationType(),
                        reqObjPart.getDataAttributes(),
                        reqObjPart.getMeta()
                ))).collect(Collectors.groupingBy(Datapoint::getIdentificationType));


        List<DatapointRuleConfiguration> datapointRuleConfigurations = DefaultRuleConfiguration.datapointRuleConfigurations;

        List<Object> datapointFactEntities = new ArrayList<>();

        try {

            for (DatapointRuleConfiguration datapointConfiguration : datapointRuleConfigurations) {

                Class datapointFactEntityClass = datapointConfiguration.getFactEntityRuleClass();

                if (datapoints.containsKey(datapointConfiguration.getIdentificationType())) {

                    if (datapointConfiguration.getIdentificationType().getPrimaryMetaDataTypes().size() == 0) {

                        int i = 0;

                        Object datapointFactEntity = datapointFactEntityClass.getDeclaredConstructor().newInstance();

                        Class datapointFlatFactEntityClass = datapointConfiguration.getFlatFactEntityRuleClass();

                        for (Datapoint datapoint : datapoints.get(datapointConfiguration.getIdentificationType())) {

                            List<DataAttribute> dataAttributes = datapoint.getDataAttributes();

                            Object datapointFlatFactEntity = datapointFlatFactEntityClass.getDeclaredConstructor().newInstance();

                            List<Field> datapointFlatFactEntityClassFields = Arrays.stream(datapointFlatFactEntityClass.getDeclaredFields()).filter(t -> {
                                return t.getDeclaredAnnotation(DataAttributeTag.class) != null;
                            }).collect(Collectors.toList());

                            for (Field datapointFlatFactEntityClassField : datapointFlatFactEntityClassFields) {

                                datapointFlatFactEntityClassField.setAccessible(true);
                                DataAttributeType dataAttributeType = datapointFlatFactEntityClassField.getDeclaredAnnotation(DataAttributeTag.class).dataAttributeType();
                                Optional<DataAttribute> dataAttribute = dataAttributes.stream().filter(item -> item.getDataAttributeType().equals(dataAttributeType)).findFirst();

                                if (dataAttribute.isPresent() && dataAttribute.get().getValue() != null) {

                                    Object attributeValue = null;

                                    if (datapointFlatFactEntityClassField.getType().equals(String.class)) {
                                        attributeValue = dataAttribute.get().getValue();
                                    } else if (datapointFlatFactEntityClassField.getType().equals(Calendar.class)) {
                                        attributeValue = DateFormattingUtility.revProcess(dataAttribute.get().getValue(), DataFormatConstant.DATE_OUTPUT_FORMAT);
                                    } else {
                                        Method attributeValueTypeMethod = datapointFlatFactEntityClassField.getType().getMethod("valueOf", String.class);
                                        attributeValueTypeMethod.setAccessible(true);
                                        try {
                                            attributeValue = attributeValueTypeMethod.invoke(null, dataAttribute.get().getValue());
                                        } catch (Exception e) {
                                            attributeValue = null;
                                        }
                                    }

                                    datapointFlatFactEntityClassField.set(datapointFlatFactEntity, attributeValue);

                                    Field datapointFactEntityClassField = datapointFactEntityClass.getDeclaredField(datapointFlatFactEntityClassField.getName());
                                    datapointFactEntityClassField.setAccessible(true);
                                    Object datapointFactEntityClassFieldValue = datapointFactEntityClassField.get(datapointFactEntity);
                                    String datapointFactEntityClassFieldAttributeFieldName = i == 0 ? "current" : ("tMinus" + i);
                                    Field datapointFactEntityClassFieldAttributeField = datapointFactEntityClassFieldValue.getClass().getDeclaredField(datapointFactEntityClassFieldAttributeFieldName);
                                    datapointFactEntityClassFieldAttributeField.setAccessible(true);
                                    datapointFactEntityClassFieldAttributeField.set(datapointFactEntityClassFieldValue, attributeValue);
                                }
                            }

                            Field fromDateField = datapointFlatFactEntityClass.getDeclaredField("datasourceDate");
                            fromDateField.setAccessible(true);
                            fromDateField.set(datapointFlatFactEntity, datapoint.getBeginning());

                            Field entitiesField = datapointFactEntityClass.getDeclaredField("entities");
                            entitiesField.setAccessible(true);
                            Object entities = entitiesField.get(datapointFactEntity);
                            ((List) entities).add(datapointFlatFactEntity);
                            i++;
                        }
                        datapointFactEntities.add(datapointFactEntity);
                    } else {
                        Map<MetaDataType, MetaColumnType> metaToColumnMapping = datapointConfiguration.getIdentificationType().getMetaToColumnMapping();
                        List<Field> primaryKeyFields = datapointConfiguration.getIdentificationType().getPrimaryMetaDataTypes().stream()
                                .map(primaryMeta -> metaToColumnMapping.get(primaryMeta).getColumnName())
                                .map(col -> {
                                    try {
                                        Field field = Datapoint.class.getDeclaredField(col);
                                        field.setAccessible(true);
                                        return field;
                                    } catch (NoSuchFieldException e) {
                                        throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Error in fetching Primary Key");
                                    }
                                }).collect(Collectors.toList());
                        Map<String, List<Datapoint>> primaryKeyWiseData = datapoints.get(datapointConfiguration.getIdentificationType()).stream()
                                .collect(Collectors.groupingBy(datapoint -> {
                                    return primaryKeyFields.stream().map(primaryKeyField -> {
                                        try {
                                            return primaryKeyField.get(datapoint).toString();
                                        } catch (IllegalAccessException e) {
                                            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Error in fetching Primary Key");
                                        }
                                    }).collect(Collectors.joining());
                                }));

                        for (Map.Entry<String, List<Datapoint>> keyValues : primaryKeyWiseData.entrySet()) {

                            int i = 0;

                            FactEntityV1 datapointFactEntity = (FactEntityV1) datapointFactEntityClass.getDeclaredConstructor().newInstance();

                            Class datapointFlatFactEntityClass = datapointConfiguration.getFlatFactEntityRuleClass();

                            datapointFactEntity.setMeta(keyValues.getKey());

                            for (Datapoint datapoint : keyValues.getValue()) {

                                List<DataAttribute> dataAttributes = datapoint.getDataAttributes();

                                Object datapointFlatFactEntity = datapointFlatFactEntityClass.getDeclaredConstructor().newInstance();

                                List<Field> datapointFlatFactEntityClassFields = Arrays.stream(datapointFlatFactEntityClass.getDeclaredFields()).filter(t -> {
                                    return t.getDeclaredAnnotation(DataAttributeTag.class) != null;
                                }).collect(Collectors.toList());

                                for (Field datapointFlatFactEntityClassField : datapointFlatFactEntityClassFields) {

                                    datapointFlatFactEntityClassField.setAccessible(true);
                                    DataAttributeType dataAttributeType = datapointFlatFactEntityClassField.getDeclaredAnnotation(DataAttributeTag.class).dataAttributeType();
                                    Optional<DataAttribute> dataAttribute = dataAttributes.stream().filter(item -> item.getDataAttributeType().equals(dataAttributeType)).findFirst();

                                    if (dataAttribute.isPresent() && dataAttribute.get().getValue() != null) {

                                        Object attributeValue = null;

                                        if (datapointFlatFactEntityClassField.getType().equals(String.class)) {
                                            attributeValue = dataAttribute.get().getValue();
                                        } else if (datapointFlatFactEntityClassField.getType().equals(Calendar.class)) {
                                            attributeValue = DateFormattingUtility.revProcess(dataAttribute.get().getValue(), DataFormatConstant.DATE_OUTPUT_FORMAT);
                                        } else {
                                            Method attributeValueTypeMethod = datapointFlatFactEntityClassField.getType().getMethod("valueOf", String.class);
                                            attributeValueTypeMethod.setAccessible(true);
                                            try {
                                                attributeValue = attributeValueTypeMethod.invoke(null, dataAttribute.get().getValue());
                                            } catch (Exception e) {
                                                attributeValue = null;
                                            }
                                        }

                                        datapointFlatFactEntityClassField.set(datapointFlatFactEntity, attributeValue);

                                        Field datapointFactEntityClassField = datapointFactEntityClass.getDeclaredField(datapointFlatFactEntityClassField.getName());
                                        datapointFactEntityClassField.setAccessible(true);
                                        Object datapointFactEntityClassFieldValue = datapointFactEntityClassField.get(datapointFactEntity);
                                        String datapointFactEntityClassFieldAttributeFieldName = i == 0 ? "current" : ("tMinus" + i);
                                        Field datapointFactEntityClassFieldAttributeField = datapointFactEntityClassFieldValue.getClass().getDeclaredField(datapointFactEntityClassFieldAttributeFieldName);
                                        datapointFactEntityClassFieldAttributeField.setAccessible(true);
                                        datapointFactEntityClassFieldAttributeField.set(datapointFactEntityClassFieldValue, attributeValue);
                                    }
                                }

                                Field fromDateField = datapointFlatFactEntityClass.getDeclaredField("datasourceDate");
                                fromDateField.setAccessible(true);
                                fromDateField.set(datapointFlatFactEntity, datapoint.getBeginning());

                                Field entitiesField = datapointFactEntityClass.getDeclaredField("entities");
                                entitiesField.setAccessible(true);
                                Object entities = entitiesField.get(datapointFactEntity);
                                ((List) entities).add(datapointFlatFactEntity);
                                i++;
                            }
                            datapointFactEntities.add(datapointFactEntity);

                        }
                    }
                }
            }

            return ResponseEntity.ok(
                    partProcess(institutionPackage, artifact, datapointFactEntities).stream()
                            .collect(Collectors.groupingBy(RuleEntity::getRuleType))
                            .entrySet().stream()
                            .map(keyset -> {
                                switch (keyset.getKey()) {
                                    case CATEGORY:
                                    case SIGNAL:
                                    case RISK_SCORE: {

                                        return Pair.of(
                                                keyset.getKey(),
                                                keyset.getValue().stream().map(ruleEntity -> {
                                                    return Map.of(ruleEntity.getRuleName(), ((NumericRuleEntity) ruleEntity).getValue());
                                                }).collect(Collectors.toList())
                                        );
                                    }
                                    case ALERT: {

                                        return Pair.of(
                                                keyset.getKey(),
                                                keyset.getValue().stream().map(ruleEntity -> {
                                                    if (ruleEntity instanceof ScoreEntityThresholdBasedAlertRuleEntity) {
                                                        return ((ScoreEntityThresholdBasedAlertRuleEntity) ruleEntity).getNumericRuleEntity().getRuleType() + " '" + ((ScoreEntityThresholdBasedAlertRuleEntity) ruleEntity).getNumericRuleEntity().getRuleName() +
                                                                "' crossed threshold of " +
                                                                ((ScoreEntityThresholdBasedAlertRuleEntity) ruleEntity).getNumericRuleEntity().getAlertThreshold();
                                                    } else {
                                                        return ruleEntity.getRuleName();
                                                    }
                                                }).collect(Collectors.toList())
                                        );
                                    }
                                    default: {

                                        throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid System Configuration of Rule Type");
                                    }
                                }
                            }).collect(Collectors.toMap(keyset -> keyset.getFirst(), keyset -> keyset.getSecond()))
            );

        } catch (ApplicationException applicationException) {
            throw applicationException;
        } catch (Exception ex) {
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
        }
    }

    @PostMapping("/data/process/detailed")
    public ResponseEntity<Map<RuleType, List<RuleEntity>>> processDetailed(@RequestBody ProcessRequest processRequest) {
        String[] tenantIdparts = processRequest.getTenantId().split("\\.");
        String artifact = tenantIdparts[tenantIdparts.length - 1];
        String institutionPackage = String.join(".", Arrays.asList(tenantIdparts).subList(0, tenantIdparts.length - 1));
        Map<IdentificationType, List<Datapoint>> datapoints = processRequest.getDataEntities().stream().flatMap(reqObj -> reqObj.getData().stream()
                .map(reqObjPart -> new Datapoint(
                        reqObj.getIdentificationType(),
                        reqObjPart.getDataAttributes(),
                        reqObjPart.getMeta()
                ))).collect(Collectors.groupingBy(Datapoint::getIdentificationType));


        List<DatapointRuleConfiguration> datapointRuleConfigurations = DefaultRuleConfiguration.datapointRuleConfigurations;

        List<Object> datapointFactEntities = new ArrayList<>();

        try {

            for (DatapointRuleConfiguration datapointConfiguration : datapointRuleConfigurations) {

                Class datapointFactEntityClass = datapointConfiguration.getFactEntityRuleClass();

                if (datapoints.containsKey(datapointConfiguration.getIdentificationType())) {

                    if (datapointConfiguration.getIdentificationType().getPrimaryMetaDataTypes().size() == 0) {

                        int i = 0;

                        Object datapointFactEntity = datapointFactEntityClass.getDeclaredConstructor().newInstance();

                        Class datapointFlatFactEntityClass = datapointConfiguration.getFlatFactEntityRuleClass();

                        for (Datapoint datapoint : datapoints.get(datapointConfiguration.getIdentificationType())) {

                            List<DataAttribute> dataAttributes = datapoint.getDataAttributes();

                            Object datapointFlatFactEntity = datapointFlatFactEntityClass.getDeclaredConstructor().newInstance();

                            List<Field> datapointFlatFactEntityClassFields = Arrays.stream(datapointFlatFactEntityClass.getDeclaredFields()).filter(t -> {
                                return t.getDeclaredAnnotation(DataAttributeTag.class) != null;
                            }).collect(Collectors.toList());

                            for (Field datapointFlatFactEntityClassField : datapointFlatFactEntityClassFields) {

                                datapointFlatFactEntityClassField.setAccessible(true);
                                DataAttributeType dataAttributeType = datapointFlatFactEntityClassField.getDeclaredAnnotation(DataAttributeTag.class).dataAttributeType();
                                Optional<DataAttribute> dataAttribute = dataAttributes.stream().filter(item -> item.getDataAttributeType().equals(dataAttributeType)).findFirst();

                                if (dataAttribute.isPresent() && dataAttribute.get().getValue() != null) {

                                    Object attributeValue = null;

                                    if (datapointFlatFactEntityClassField.getType().equals(String.class)) {
                                        attributeValue = dataAttribute.get().getValue();
                                    } else if (datapointFlatFactEntityClassField.getType().equals(Calendar.class)) {
                                        attributeValue = DateFormattingUtility.revProcess(dataAttribute.get().getValue(), DataFormatConstant.DATE_OUTPUT_FORMAT);
                                    } else {
                                        Method attributeValueTypeMethod = datapointFlatFactEntityClassField.getType().getMethod("valueOf", String.class);
                                        attributeValueTypeMethod.setAccessible(true);
                                        try {
                                            attributeValue = attributeValueTypeMethod.invoke(null, dataAttribute.get().getValue());
                                        } catch (Exception e) {
                                            attributeValue = null;
                                        }
                                    }

                                    datapointFlatFactEntityClassField.set(datapointFlatFactEntity, attributeValue);

                                    Field datapointFactEntityClassField = datapointFactEntityClass.getDeclaredField(datapointFlatFactEntityClassField.getName());
                                    datapointFactEntityClassField.setAccessible(true);
                                    Object datapointFactEntityClassFieldValue = datapointFactEntityClassField.get(datapointFactEntity);
                                    String datapointFactEntityClassFieldAttributeFieldName = i == 0 ? "current" : ("tMinus" + i);
                                    Field datapointFactEntityClassFieldAttributeField = datapointFactEntityClassFieldValue.getClass().getDeclaredField(datapointFactEntityClassFieldAttributeFieldName);
                                    datapointFactEntityClassFieldAttributeField.setAccessible(true);
                                    datapointFactEntityClassFieldAttributeField.set(datapointFactEntityClassFieldValue, attributeValue);
                                }
                            }

                            Field fromDateField = datapointFlatFactEntityClass.getDeclaredField("datasourceDate");
                            fromDateField.setAccessible(true);
                            fromDateField.set(datapointFlatFactEntity, datapoint.getBeginning());

                            Field entitiesField = datapointFactEntityClass.getDeclaredField("entities");
                            entitiesField.setAccessible(true);
                            Object entities = entitiesField.get(datapointFactEntity);
                            ((List) entities).add(datapointFlatFactEntity);
                            i++;
                        }
                        datapointFactEntities.add(datapointFactEntity);
                    } else {
                        Map<MetaDataType, MetaColumnType> metaToColumnMapping = datapointConfiguration.getIdentificationType().getMetaToColumnMapping();
                        List<Field> primaryKeyFields = datapointConfiguration.getIdentificationType().getPrimaryMetaDataTypes().stream()
                                .map(primaryMeta -> metaToColumnMapping.get(primaryMeta).getColumnName())
                                .map(col -> {
                                    try {
                                        Field field = Datapoint.class.getDeclaredField(col);
                                        field.setAccessible(true);
                                        return field;
                                    } catch (NoSuchFieldException ex) {
                                        throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
                                    }
                                }).collect(Collectors.toList());
                        Map<String, List<Datapoint>> primaryKeyWiseData = datapoints.get(datapointConfiguration.getIdentificationType()).stream()
                                .collect(Collectors.groupingBy(datapoint -> {
                                    return primaryKeyFields.stream().map(primaryKeyField -> {
                                        try {
                                            return primaryKeyField.get(datapoint).toString();
                                        } catch (IllegalAccessException ex) {
                                            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
                                        }
                                    }).collect(Collectors.joining());
                                }));

                        for (Map.Entry<String, List<Datapoint>> keyValues : primaryKeyWiseData.entrySet()) {

                            int i = 0;

                            FactEntityV1 datapointFactEntity = (FactEntityV1) datapointFactEntityClass.getDeclaredConstructor().newInstance();

                            Class datapointFlatFactEntityClass = datapointConfiguration.getFlatFactEntityRuleClass();

                            datapointFactEntity.setMeta(keyValues.getKey());

                            for (Datapoint datapoint : keyValues.getValue()) {

                                List<DataAttribute> dataAttributes = datapoint.getDataAttributes();

                                Object datapointFlatFactEntity = datapointFlatFactEntityClass.getDeclaredConstructor().newInstance();

                                List<Field> datapointFlatFactEntityClassFields = Arrays.stream(datapointFlatFactEntityClass.getDeclaredFields()).filter(t -> {
                                    return t.getDeclaredAnnotation(DataAttributeTag.class) != null;
                                }).collect(Collectors.toList());

                                for (Field datapointFlatFactEntityClassField : datapointFlatFactEntityClassFields) {

                                    datapointFlatFactEntityClassField.setAccessible(true);
                                    DataAttributeType dataAttributeType = datapointFlatFactEntityClassField.getDeclaredAnnotation(DataAttributeTag.class).dataAttributeType();
                                    Optional<DataAttribute> dataAttribute = dataAttributes.stream().filter(item -> item.getDataAttributeType().equals(dataAttributeType)).findFirst();

                                    if (dataAttribute.isPresent() && dataAttribute.get().getValue() != null) {

                                        Object attributeValue = null;

                                        if (datapointFlatFactEntityClassField.getType().equals(String.class)) {
                                            attributeValue = dataAttribute.get().getValue();
                                        } else if (datapointFlatFactEntityClassField.getType().equals(Calendar.class)) {
                                            attributeValue = DateFormattingUtility.revProcess(dataAttribute.get().getValue(), DataFormatConstant.DATE_OUTPUT_FORMAT);
                                        } else {
                                            Method attributeValueTypeMethod = datapointFlatFactEntityClassField.getType().getMethod("valueOf", String.class);
                                            attributeValueTypeMethod.setAccessible(true);
                                            try {
                                                attributeValue = attributeValueTypeMethod.invoke(null, dataAttribute.get().getValue());
                                            } catch (Exception e) {
                                                attributeValue = null;
                                            }
                                        }

                                        datapointFlatFactEntityClassField.set(datapointFlatFactEntity, attributeValue);

                                        Field datapointFactEntityClassField = datapointFactEntityClass.getDeclaredField(datapointFlatFactEntityClassField.getName());
                                        datapointFactEntityClassField.setAccessible(true);
                                        Object datapointFactEntityClassFieldValue = datapointFactEntityClassField.get(datapointFactEntity);
                                        String datapointFactEntityClassFieldAttributeFieldName = i == 0 ? "current" : ("tMinus" + i);
                                        Field datapointFactEntityClassFieldAttributeField = datapointFactEntityClassFieldValue.getClass().getDeclaredField(datapointFactEntityClassFieldAttributeFieldName);
                                        datapointFactEntityClassFieldAttributeField.setAccessible(true);
                                        datapointFactEntityClassFieldAttributeField.set(datapointFactEntityClassFieldValue, attributeValue);
                                    }
                                }

                                Field fromDateField = datapointFlatFactEntityClass.getDeclaredField("datasourceDate");
                                fromDateField.setAccessible(true);
                                fromDateField.set(datapointFlatFactEntity, datapoint.getBeginning());

                                Field entitiesField = datapointFactEntityClass.getDeclaredField("entities");
                                entitiesField.setAccessible(true);
                                Object entities = entitiesField.get(datapointFactEntity);
                                ((List) entities).add(datapointFlatFactEntity);
                                i++;
                            }
                            datapointFactEntities.add(datapointFactEntity);

                        }
                    }
                }
            }

            return ResponseEntity.ok(
                    partProcess(institutionPackage, artifact, datapointFactEntities).stream()
                            .collect(Collectors.groupingBy(RuleEntity::getRuleType))
            );

        } catch (ApplicationException ex) {

            throw ex;
        } catch (Exception ex) {

            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
        }
    }

    private List<RuleEntity> partProcess(String institutionPackage, String artifact, List<Object> datapointFactEntities) {

        List<RuleEntity> overallRuleEntities = Collections.emptyList();

        if (datapointFactEntities.size() > 0) {

            Map<RuleType, Boolean> areManualsAdded = new HashMap<>();

            overallRuleEntities = partProcessCompute(institutionPackage, artifact, datapointFactEntities, areManualsAdded);

            Map<RuleType, List<RuleEntity>> typeWiseRuleEntities = overallRuleEntities.stream()
                    .collect(Collectors.groupingBy(RuleEntity::getRuleType));

            for (RuleType ruleType : RuleType.values()) {

                List<RuleEntity> ruleEntities = typeWiseRuleEntities.getOrDefault(ruleType, Collections.emptyList());
            }

        }

        return overallRuleEntities;
    }

    private List<RuleEntity> partProcessCompute(String institutionPackage, String artifact, List<Object> datapointFactEntities, Map<RuleType, Boolean> areManualsAdded) {

        List<RuleEntity> ruleEntitiesPart = this.vendorService.processRequest(
                institutionPackage,
                artifact,
                datapointFactEntities
        );

        List<RuleEntity> overallRuleEntities = new ArrayList<>();

        if (ruleEntitiesPart.size() > 0) {

            List<Object> ruleEntitiesPartWithManual = new ArrayList<>();

            Set<RuleType> typeWiseRuleEntities = ruleEntitiesPart.stream()
                    .map(RuleEntity::getRuleType).collect(Collectors.toSet());

            for (RuleType ruleType : typeWiseRuleEntities) {

                List<RuleEntity> filtereRuleTypeBasedRuleEntities = ruleEntitiesPart.stream()
                        .filter(ruleEntityPart -> ruleEntityPart.getRuleType() == ruleType)
                        .collect(Collectors.toList());

                overallRuleEntities.addAll(filtereRuleTypeBasedRuleEntities);
                ruleEntitiesPartWithManual.addAll(filtereRuleTypeBasedRuleEntities);
            }

            overallRuleEntities.addAll(partProcessCompute(institutionPackage, artifact, ruleEntitiesPartWithManual, areManualsAdded));
        }

        return overallRuleEntities;
    }
}
