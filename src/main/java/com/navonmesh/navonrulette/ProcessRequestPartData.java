package com.navonmesh.navonrulette;

import com.navonmesh.navonrulette.rule.MetaDataType;
import com.navonmesh.navonrulette.rule.DataAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessRequestPartData {

    private List<DataAttribute> dataAttributes;

    private Map<MetaDataType, String> meta;
}
