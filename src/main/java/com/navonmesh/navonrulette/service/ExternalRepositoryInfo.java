package com.navonmesh.navonrulette.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalRepositoryInfo {

    private String url;

    private String username;

    private String password;
}
