package com.navonmesh.navonrulette.rule;

public enum MetaColumnType {
    FROM("beginning", MetaColumnTypeDataType.CALENDAR),
    TO("ending", MetaColumnTypeDataType.CALENDAR),
    META1("meta1", MetaColumnTypeDataType.STRING),
    META2("meta2", MetaColumnTypeDataType.STRING),
    META3("meta3", MetaColumnTypeDataType.STRING),
    META4("meta4", MetaColumnTypeDataType.STRING),
    META5("meta5", MetaColumnTypeDataType.STRING),
    META6("meta6", MetaColumnTypeDataType.STRING),
    META7("meta7", MetaColumnTypeDataType.STRING);

    private String columnName;

    private MetaColumnTypeDataType metaColumnTypeDataType;


    MetaColumnType(String columnName, MetaColumnTypeDataType metaColumnTypeDataType) {
        this.columnName = columnName;
        this.metaColumnTypeDataType = metaColumnTypeDataType;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public MetaColumnTypeDataType getMetaColumnTypeDataType() {
        return metaColumnTypeDataType;
    }
}
