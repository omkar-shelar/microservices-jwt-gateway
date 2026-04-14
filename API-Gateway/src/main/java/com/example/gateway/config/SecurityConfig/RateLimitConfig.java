package com.example.gateway.config.SecurityConfig;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import reactor.core.publisher.Mono;

@Configuration
public class RateLimitConfig {

    // 👤 Per USER (uses JwtFilter header)
    @Bean
    @Primary 
    public KeyResolver userKeyResolver() {
        return exchange -> {
            String user = exchange.getRequest()
                    .getHeaders()
                    .getFirst("user");

            return Mono.just(user != null ? user : "anonymous");
        };
    }

    // 🌐 Per IP (for login/auth)
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(
            exchange.getRequest()
                    .getRemoteAddress()
                    .getAddress()
                    .getHostAddress()
        );
    }
}