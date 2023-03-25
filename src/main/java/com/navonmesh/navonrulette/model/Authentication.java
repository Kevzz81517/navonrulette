package com.navonmesh.navonrulette.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {

    private String apiKey;

    private String tenantId;
}
