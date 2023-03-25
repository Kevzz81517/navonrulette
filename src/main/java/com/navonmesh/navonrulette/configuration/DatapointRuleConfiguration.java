package com.navonmesh.navonrulette.configuration;

import com.navonmesh.navonrulette.configuration.type.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatapointRuleConfiguration {

    private IdentificationType identificationType;

    private Class factEntityRuleClass;

    private Class flatFactEntityRuleClass;
}
