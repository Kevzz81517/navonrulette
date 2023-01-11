package com.navonmesh.navonrulette;

import com.navonmesh.navonrulette.service.VendorServiceImpl;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NavonruletteApplication {

	@SneakyThrows
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(NavonruletteApplication.class, args);
		cac.getBean(VendorServiceImpl.class).addTenantKieContainer(
				"com.navonmeshclient",
				"deciders", "1.0.0-SNAPSHOT",
				"http://localhost:8080/business-central/maven2",
				"admin",
				"admin"
		);
	}

}
