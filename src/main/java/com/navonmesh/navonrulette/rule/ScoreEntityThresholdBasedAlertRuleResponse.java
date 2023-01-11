package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ScoreEntityThresholdBasedAlertRuleResponse extends RuleResponse {

    private NumericRuleEntity numericRuleEntity;

    public ScoreEntityThresholdBasedAlertRuleResponse(String ruleName, NumericRuleEntity numericRuleEntity) {
        super(ruleName);
        this.numericRuleEntity = numericRuleEntity;
    }
}
