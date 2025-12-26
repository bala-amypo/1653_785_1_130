package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class RepositoryConfig {

    @Bean
    public UserRepository userRepository() {

        // Anonymous implementation (NO DB, NO JPA)
        return new UserRepository() {

            @Override
            public Optional<User> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public User save(User user) {
                return user;
            }
        };
    }
}
