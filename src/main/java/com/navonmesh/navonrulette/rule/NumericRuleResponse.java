package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class NumericRuleResponse extends RuleResponse {

    private double value;

    private Object[] supportingValues;

    public NumericRuleResponse(String ruleName, double value, Object[] supportingValues) {
        super(ruleName);
        this.value = Double.parseDouble(String.format("%.2f", value));
        this.supportingValues = supportingValues;
    }

    public NumericRuleResponse(String ruleName, double value) {
        super(ruleName);
        this.value = Double.parseDouble(String.format("%.2f", value));
    }
}
