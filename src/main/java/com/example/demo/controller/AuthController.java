package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        service.registerUser(req);
        return "User Registered";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        String token = service.loginUser(req);
        return new AuthResponse(token);
    }
}
