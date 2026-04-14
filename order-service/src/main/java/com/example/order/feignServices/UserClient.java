package com.example.order.feignServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE")   
public interface UserClient {

    @GetMapping("/users/getAll")
    Object getUsers();
}