package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.DataAttributeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataAttribute {

    private DataAttributeType dataAttributeType;

    private String value;
}
