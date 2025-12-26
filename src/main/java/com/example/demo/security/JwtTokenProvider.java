package com.example.demo.security;

import java.util.Set;

public class JwtTokenProvider {
    public String createToken(Long id, String email, Set<String> roles) {
        return "token";
    }

    public boolean validateToken(String token) {
        return false;
    }
}
