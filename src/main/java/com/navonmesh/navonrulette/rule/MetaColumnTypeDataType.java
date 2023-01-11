package com.navonmesh.navonrulette.rule;


import com.navonmesh.navonrulette.configuration.DataFormatConstant;
import com.navonmesh.navonrulette.configuration.DateFormattingUtility;

import java.util.Calendar;

interface MetaColumnTypeDataTypeMethod {

    Object convert(String value);
}

public enum MetaColumnTypeDataType implements MetaColumnTypeDataTypeMethod {

    CALENDAR(Calendar.class) {
        @Override
        public Object convert(String date) {

            return DateFormattingUtility.revProcess(date, DataFormatConstant.DATE_INPUT_FORMAT);
        }
    },
    STRING(String.class) {
        @Override
        public Object convert(String value) {

            return value;
        }
    };

    final private Class typeClass;

    MetaColumnTypeDataType(Class typeClass) {

        this.typeClass = typeClass;
    }

    public Class getTypeClass() {
        return typeClass;
    }
}
