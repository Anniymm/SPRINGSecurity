package com.auth.auth.services;

import com.auth.auth.dto.UserRegistrationRequest;
import com.auth.auth.models.User;
import com.auth.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationRequest userRegistrationDTO) {
        // Check if the email or username already exists
        if (userRepository.findByUsername(userRegistrationDTO.getUsername()) != null) {
            throw new IllegalArgumentException("Username already taken.");
        }
        if (userRepository.findByEmail(userRegistrationDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Email already in use.");
        }

        // Password match check
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        // Create new User object
        User user = new User();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setRole("USER");  // Set default role as USER

        // Save user to the database
        return userRepository.save(user);
    }
}
