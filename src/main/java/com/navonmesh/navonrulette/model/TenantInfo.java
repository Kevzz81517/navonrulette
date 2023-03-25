package com.navonmesh.navonrulette.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantInfo {

    private String url;

    private String username;

    private String password;

    private String apiKey;
}
