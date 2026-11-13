package com.example.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		classes = GatewayApplication.class,
		properties = {
			"CONFIG_IMPORT=optional:file:./",
			"spring.cloud.config.enabled=false",
			"spring.cloud.discovery.enabled=false",
			"eureka.client.enabled=false",
			"spring.autoconfigure.exclude=org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration,org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration",
			"jwt.secret=test-secret-test-secret-test-secret-123456"
		})
class GatewayApplicationTests {

	static {
		System.setProperty("CONFIG_IMPORT", "optional:file:./");
	}

	@Test
	void contextLoads() {
	}

}
