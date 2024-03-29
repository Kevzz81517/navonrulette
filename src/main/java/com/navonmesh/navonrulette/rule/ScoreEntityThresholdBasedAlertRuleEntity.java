package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ScoreEntityThresholdBasedAlertRuleEntity extends AlertRuleEntity {

    private NumericRuleEntity numericRuleEntity;

    public ScoreEntityThresholdBasedAlertRuleEntity(RuleType ruleType, String ruleName, NumericRuleEntity numericRuleEntity) {
        super(ruleType, ruleName);
        this.numericRuleEntity = numericRuleEntity;
    }

    @Override
    public String getKey() {
        return super.getRuleName() + "|" + this.numericRuleEntity.getRuleName();
    }
}
