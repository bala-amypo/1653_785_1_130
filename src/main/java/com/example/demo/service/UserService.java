package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;

public interface UserService {

    void registerUser(RegisterRequest req);

    String loginUser(AuthRequest req);
}
