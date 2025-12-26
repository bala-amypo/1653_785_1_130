package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository userRepo,
                          PasswordEncoder encoder,
                          JwtTokenProvider jwt) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {

        // Check duplicate email
        if (userRepo.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(409)
                    .body("Email already exists");
        }

        // Default role if not provided
        Set<String> roles =
                (req.getRoles() == null || req.getRoles().isEmpty())
                        ? Set.of("USER")
                        : req.getRoles();

        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .roles(roles)
                .build();

        userRepo.save(user);

        String token = jwt.createToken(
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );

        return ResponseEntity.ok(new AuthResponse(token));
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        return userRepo.findByEmail(req.getEmail())
                .filter(user ->
                        encoder.matches(req.getPassword(), user.getPassword()))
                .map(user -> ResponseEntity.ok(
                        new AuthResponse(
                                jwt.createToken(
                                        user.getId(),
                                        user.getEmail(),
                                        user.getRoles())
                        )
                ))
                .orElse(
                        ResponseEntity
                                .status(401)
                                .body("Invalid email or password")
                );
    }
}
