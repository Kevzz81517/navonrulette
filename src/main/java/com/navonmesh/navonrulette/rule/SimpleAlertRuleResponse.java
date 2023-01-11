package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SimpleAlertRuleResponse extends RuleResponse {

    public SimpleAlertRuleResponse(String ruleName) {
        super(ruleName);
    }
}
