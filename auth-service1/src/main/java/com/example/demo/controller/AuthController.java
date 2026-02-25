package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        return authService.login(
                request.get("email"),
                request.get("password")
        );
    }

    @GetMapping("/validate-token")
    public boolean validate(@RequestHeader("Authorization") String header) {

        String token = header.replace("Bearer ", "");
        return authService.validate(token);
    }
}