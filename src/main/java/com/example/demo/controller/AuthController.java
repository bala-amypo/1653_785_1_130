package com.example.demo.controller;

import org.springframework.http.*;
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
        if (repo.findByEmail(r.getEmail()).isPresent())
            return ResponseEntity.status(409).build();

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
        if (!encoder.matches(r.getPassword(), u.getPassword()))
            return ResponseEntity.status(401).build();

        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
