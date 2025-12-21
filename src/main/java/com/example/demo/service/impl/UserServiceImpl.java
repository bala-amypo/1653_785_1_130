package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(RegisterRequest req) {
        // simple
    }

    @Override
    public String loginUser(AuthRequest req) {
        return "TOKEN";
    }
}
