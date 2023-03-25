package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.RuleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SimpleAlertRuleEntity extends AlertRuleEntity {

    private List<String> supportingTags;

    public SimpleAlertRuleEntity(RuleType ruleType, String ruleName, List<String> supportingTags) {
        super(ruleType, ruleName);
        this.supportingTags = supportingTags;
    }

    @Override
    public String getKey() {
        return super.getRuleName();
    }
}
