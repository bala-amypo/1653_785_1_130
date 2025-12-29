package com.example.demo.model;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
private String role;
}
