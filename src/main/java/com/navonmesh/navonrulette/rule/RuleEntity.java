package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RuleEntity {

    private String reference;

    private RuleType ruleType;

    private String ruleName;

    public RuleEntity(String reference, RuleType ruleType, String ruleName) {
        this.reference = reference;
        this.ruleType = ruleType;
        this.ruleName = ruleName;
    }
}
