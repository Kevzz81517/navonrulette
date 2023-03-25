package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RuleEntity {

    private RuleType ruleType;

    private String ruleName;

    public RuleEntity(RuleType ruleType, String ruleName) {
        this.ruleType = ruleType;
        this.ruleName = ruleName;
    }
}
