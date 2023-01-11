package com.navonmesh.navonrulette.rule.type;

import java.util.Arrays;
import java.util.List;

public enum DataAttributeDataType {
    NUMBER,
    BOOLEAN,
    TEXT,
    MULTI_PART_TEXT,
    DATE,
    IMAGE,
    PDF,
    DROPDOWN;

    public static List<DataAttributeDataType> getDocumentDataAttributeDataType() {
        return Arrays.asList(IMAGE, PDF);
    }
}
