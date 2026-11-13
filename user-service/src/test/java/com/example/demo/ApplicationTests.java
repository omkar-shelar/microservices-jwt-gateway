package com.example.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		classes = Application.class,
		properties = {
			"CONFIG_IMPORT=optional:file:./",
			"spring.cloud.config.enabled=false",
			"spring.cloud.discovery.enabled=false",
			"eureka.client.enabled=false",
			"spring.autoconfigure.exclude=org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration,org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration",
			"spring.data.redis.host=localhost",
			"spring.data.redis.port=6379"
		})
class ApplicationTests {

	static {
		System.setProperty("CONFIG_IMPORT", "optional:file:./");
	}

	@Test
	void contextLoads() {
	}

}
