package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RiskScoreRuleResponse extends NumericRuleResponse {

    public RiskScoreRuleResponse(String ruleName, double value, Object[] supportingValues) {
        super(ruleName, value, supportingValues);
    }

    public RiskScoreRuleResponse(String ruleName, double value) {
        super(ruleName, value);
    }
}
