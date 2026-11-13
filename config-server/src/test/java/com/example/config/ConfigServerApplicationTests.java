package com.example.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		classes = ConfigServerApplication.class,
		properties = {
			"eureka.client.enabled=false",
			"spring.cloud.discovery.enabled=false",
			"spring.cloud.config.server.native.search-locations=classpath:/"
		})
class ConfigServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
