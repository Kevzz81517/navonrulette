package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.type.DataAttributeType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public @Retention(RetentionPolicy.RUNTIME)
@interface DataAttributeTag {

    DataAttributeType dataAttributeType();
}
