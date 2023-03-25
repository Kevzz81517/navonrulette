package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.AlertSeverityType;
import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRuleEntity extends NumericRuleEntity {

    private double weightage;

    private Map<RuleType, List<String>> affectingReferences;

    private List<String> supportingTags;

    private Calendar datasourceDate;

    public CategoryRuleEntity(RuleType ruleType, double value, String ruleName, Map<RuleType,
            List<String>> affectingReferences, double weightage, List<String> supportingTags, Calendar datasourceDate, Double alertThreshold, Object[] supportingValues,
                              String supportingDescription, AlertSeverityType alertSeverity) {
        super(ruleType, value, ruleName, alertThreshold, supportingValues, supportingDescription, alertSeverity);
        this.affectingReferences = affectingReferences;
        this.weightage = weightage;
        this.datasourceDate = datasourceDate;
        this.supportingTags = supportingTags;
    }
}
