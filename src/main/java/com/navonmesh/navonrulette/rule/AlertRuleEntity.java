package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class AlertRuleEntity extends RuleEntity {

    public AlertRuleEntity(String reference, RuleType ruleType, String ruleName) {
        super(reference, ruleType, ruleName);
    }

    public abstract String getKey();
}
