package com.example.demo.model;

import lombok.*;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    @Builder.Default
    private Set<String> roles = new HashSet<>();
}
