package com.example.demo.security;

import jakarta.servlet.*;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    public JwtAuthenticationFilter(JwtTokenProvider p,
                                   CustomUserDetailsService u) {}

    @Override
    public void doFilter(ServletRequest r, ServletResponse s,
                         FilterChain c)
            throws IOException, ServletException {
        c.doFilter(r, s);
    }
}
