package com.example.auth.controller;

import com.example.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${auth.admin.username}")
    private String configuredUsername;

    @Value("${auth.admin.password}")
    private String configuredPassword;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (configuredUsername.equals(username) && configuredPassword.equals(password)) {
            return jwtUtil.generateToken(username);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
