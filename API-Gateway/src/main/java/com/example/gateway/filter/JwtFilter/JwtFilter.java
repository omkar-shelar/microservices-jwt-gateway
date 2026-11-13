package com.example.gateway.filter.JwtFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.example.gateway.util.JwtUtil;

import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements GlobalFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        if (isPublicPath(path)) {
            return chain.filter(exchange);
        }

        if (!isProtectedPath(path)) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        // ❌ Missing or invalid header
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        // ❌ Invalid token
        if (!jwtUtil.validateToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // ✅ OPTIONAL: pass username to downstream services
        String username = jwtUtil.extractUsername(token);

        exchange = exchange.mutate()
                .request(r -> r.header("user", username))
                .build();

        // ✅ Continue request
        return chain.filter(exchange);
    }

    private boolean isPublicPath(String path) {
        return path.equals("/auth") || path.startsWith("/auth/");
    }

    private boolean isProtectedPath(String path) {
        return path.equals("/users") || path.startsWith("/users/")
                || path.equals("/orders") || path.startsWith("/orders/")
                || path.equals("/secure") || path.startsWith("/secure/");
    }
}
