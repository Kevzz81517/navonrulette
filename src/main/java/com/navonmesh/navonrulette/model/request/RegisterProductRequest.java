package com.navonmesh.navonrulette.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterProductRequest {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "URL is mandatory")
    private String url;

    @NotBlank(message = "Version is mandatory")
    private String version;

    @NotBlank(message = "Tenant Id  is mandatory")
    @Pattern(regexp = "[a-z0-9_]+\\.[a-z0-9_.]+", message = "Invalid Tenant Id Format")
    private String tenantId;

}
