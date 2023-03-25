package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.AlertSeverityType;
import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class NumericRuleEntity extends RuleEntity {

    private double value;

    private Double alertThreshold;

    private AlertSeverityType alertSeverity;

    private Object[] supportingValues;

    private String supportingDescription;

    public NumericRuleEntity(RuleType ruleType, double value, String ruleName, Double alertThreshold, Object[] supportingValues, String supportingDescription, AlertSeverityType alertSeverity) {
        super(ruleType, ruleName);
        this.value = value;
        this.alertThreshold = alertThreshold;
        if (supportingValues != null && supportingValues.length > 0) {
            this.supportingValues = Arrays.stream(supportingValues).map(item -> {
                if (item instanceof Number) {
                    return String.format("%.2f", item);
                } else {
                    return item;
                }
            }).toArray();
        }
        this.supportingDescription = supportingDescription;
        this.alertSeverity = alertSeverity;
    }
}
