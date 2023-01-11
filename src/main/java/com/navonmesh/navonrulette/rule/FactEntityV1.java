package com.navonmesh.navonrulette.rule;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public abstract class FactEntityV1 implements Serializable {

    private transient String displayName;

    private String meta;

    public FactEntityV1(String displayName) {
        this.displayName = displayName;
    }
}
