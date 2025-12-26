package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;

public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository r, PasswordEncoder e, JwtTokenProvider j) {
        this.repo = r;
        this.encoder = e;
        this.jwt = j;
    }

    public ResponseEntity<?> register(RegisterRequest r) {
        User u = User.builder()
                .email(r.getEmail())
                .password(encoder.encode(r.getPassword()))
                .roles(r.getRoles())
                .name(r.getName())
                .build();

        u = repo.save(u);
        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    public ResponseEntity<?> login(AuthRequest r) {
        User u = repo.findByEmail(r.getEmail()).orElseThrow();
        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
