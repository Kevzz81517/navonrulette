package com.navonmesh.navonrulette.configuration;

import com.navonmesh.navonrulette.rule.IndividualEquifaxReportFactEntityV1;
import com.navonmesh.navonrulette.rule.IndividualEquifaxReportFlatFactEntityV1;
import com.navonmesh.navonrulette.exception.ApplicationException;

import java.util.List;

public class DefaultRuleConfiguration {

    public static int records = 6;

    public static List<DatapointRuleConfiguration> datapointRuleConfigurations = List.of(
            DatapointRuleConfiguration.builder()
                    .identificationType(IdentificationType.INDIVIDUAL_EQUIFAX_REPORT)
                    .factEntityRuleClass(IndividualEquifaxReportFactEntityV1.class)
                    .flatFactEntityRuleClass(IndividualEquifaxReportFlatFactEntityV1.class)
                    .build()
    );

    public static IdentificationType getIdentificationTypeFromFactEntityRuleClass(Class factEntityRuleClass) {
        for (var defaultRuleConfiguration : datapointRuleConfigurations) {
            if (defaultRuleConfiguration.getFactEntityRuleClass().equals(factEntityRuleClass)) {
                return defaultRuleConfiguration.getIdentificationType();
            }
        }
        throw new ApplicationException("Invalid Definition");
    }
}
