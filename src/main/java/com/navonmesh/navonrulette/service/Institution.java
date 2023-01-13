package com.navonmesh.navonrulette.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institution {

    private String username;

    private String password;

    private String url;

    private String version;

    private String tenantId;
}
