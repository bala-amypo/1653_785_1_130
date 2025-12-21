package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters and setters
}
