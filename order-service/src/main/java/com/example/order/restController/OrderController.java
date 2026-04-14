package com.example.order.restController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.feignServices.UserClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OrderController {

    private final UserClient userClient;

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/orders")
    public Map<String, Object> getOrders() {

        Object users = userClient.getUsers();   

        return Map.of(
                "orderId", 101,
                "user", users
        );
    }
}
