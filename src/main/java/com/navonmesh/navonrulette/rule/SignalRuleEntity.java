package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.AlertSeverityType;
import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SignalRuleEntity extends NumericRuleEntity {

    private List<String> supportingCategories;

    private List<String> supportingTags;

    private List<String> datasource;

    private Calendar datasourceDate;

    private double weightage;

    public SignalRuleEntity(String reference, RuleType ruleType, Double value, String ruleName, List<String> supportingCategories,
                            List<String> supportingTags, Calendar datasourceDate, List<String> datasource, double weightage, Double alertThreshold,
                            Object[] supportingValues, String supportingDescription, AlertSeverityType alertSeverity) {
        super(reference, ruleType, value, ruleName, alertThreshold, supportingValues, supportingDescription, alertSeverity);
        this.supportingCategories = supportingCategories;
        this.supportingTags = supportingTags;
        this.weightage = weightage;
        this.datasource = datasource;
        this.datasourceDate = datasourceDate;
    }
}
