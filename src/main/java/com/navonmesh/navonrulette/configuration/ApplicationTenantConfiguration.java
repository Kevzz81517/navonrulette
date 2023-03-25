package com.navonmesh.navonrulette.configuration;

import com.navonmesh.navonrulette.model.Institution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("ApplicationConfiguration")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "appconfigurations")
public class ApplicationTenantConfiguration {

    private List<Institution> institutions = new ArrayList<>();

    private String licenceClient;

    private String licenceSecret;

}
