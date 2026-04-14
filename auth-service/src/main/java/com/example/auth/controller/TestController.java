package com.example.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/secure")
    public String secure() {
        return "Secure API ✅";
    }

    @GetMapping("/secure2")
    public String secure2() {
        return "Secure2 API ✅";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin API 🔐";
    }
}