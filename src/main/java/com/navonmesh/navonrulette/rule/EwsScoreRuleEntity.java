package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.AlertSeverityType;
import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EwsScoreRuleEntity extends NumericRuleEntity {

    private List<String> supportingTags;

    public EwsScoreRuleEntity(String reference, RuleType ruleType, double value, String ruleName, Double alertThreshold, List<String> supportingTags, Object[] supportingValues, String supportingDescription, AlertSeverityType alertSeverity) {
        super(reference, ruleType, value, ruleName, alertThreshold, supportingValues, supportingDescription, alertSeverity);
        this.supportingTags = supportingTags;
    }
}
