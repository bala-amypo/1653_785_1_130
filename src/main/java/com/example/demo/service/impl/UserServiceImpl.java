// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;

// import java.util.*;
// import java.util.concurrent.atomic.AtomicLong;

// @Service
// public class UserServiceImpl implements UserService {

//     private final Map<Long, User> usersById = new HashMap<>();
//     private final Map<String, User> usersByEmail = new HashMap<>();
//     private final AtomicLong idGen = new AtomicLong(1);

//     @Override
//     public User createUser(User user) {
//         if (usersByEmail.containsKey(user.getEmail())) {
//             throw new IllegalArgumentException("Email already exists");
//         }

//         user.setId(idGen.getAndIncrement());

//         // ensure roles not null
//         if (user.getRoles() == null) {
//             user.setRoles(Set.of("USER"));
//         }

//         usersById.put(user.getId(), user);
//         usersByEmail.put(user.getEmail(), user);
//         return user;
//     }

//     @Override
//     public Optional<User> getUserById(Long id) {
//         return Optional.ofNullable(usersById.get(id));
//     }

//     @Override
//     public Optional<User> getUserByEmail(String email) {
//         return Optional.ofNullable(usersByEmail.get(email));
//     }

//     @Override
//     public List<User> getAllUsers() {
//         return new ArrayList<>(usersById.values());
//     }

//     @Override
//     public User updateUser(Long id, User user) {
//         User existing = usersById.get(id);
//         if (existing == null) {
//             throw new NoSuchElementException("User not found");
//         }

//         user.setId(id);
//         usersById.put(id, user);
//         usersByEmail.put(user.getEmail(), user);
//         return user;
//     }

//     @Override
//     public void deleteUser(Long id) {
//         User removed = usersById.remove(id);
//         if (removed != null) {
//             usersByEmail.remove(removed.getEmail());
//         }
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.entity.Role;

@Service
public class UserServiceImpl implements UserService {
 
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
   

    public UserServiceImpl(UserRepository repo,PasswordEncoder encoder) {
        this.userRepository = repo;
        this.encoder = encoder;
    }

    @Override
    public User register(User user) {

        if (user.getEmail() == null || user.getEmail().isBlank())
            throw new IllegalArgumentException("Email cannot be empty");

        if (user.getPassword() == null || user.getPassword().isBlank())
            throw new IllegalArgumentException("Password cannot be empty");

   
        user.setPassword(encoder.encode(user.getPassword()));

       if (user.getRole() == null) {
    user.setRole("USER");
}

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}