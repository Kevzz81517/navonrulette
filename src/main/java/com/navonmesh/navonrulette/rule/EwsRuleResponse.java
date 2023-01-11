package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EwsRuleResponse extends NumericRuleResponse {

    public EwsRuleResponse(String ruleName, double value, Object[] supportingValues) {
        super(ruleName, value, supportingValues);
    }

    public EwsRuleResponse(String ruleName, double value) {
        super(ruleName, value);
    }
}
