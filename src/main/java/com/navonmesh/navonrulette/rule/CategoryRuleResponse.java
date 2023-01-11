package com.navonmesh.navonrulette.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CategoryRuleResponse extends NumericRuleResponse {

    public CategoryRuleResponse(String ruleName, double value, Object[] supportingValues) {
        super(ruleName, value, supportingValues);
    }

    public CategoryRuleResponse(String ruleName, double value) {
        super(ruleName, value);
    }
}
