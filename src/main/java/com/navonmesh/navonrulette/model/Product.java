package com.navonmesh.navonrulette.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String artifactId;

    private String versionPattern;

    private String username;

    private String password;

    private String url;

}
