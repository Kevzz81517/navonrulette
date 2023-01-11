package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SignalRuleResponse extends NumericRuleResponse {

    public SignalRuleResponse(String ruleName, double value, Object[] supportingValues) {
        super(ruleName, value, supportingValues);
    }

    public SignalRuleResponse(String ruleName, double value) {
        super(ruleName, value);
    }
}
