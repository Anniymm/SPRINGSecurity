package com.auth.auth.controllers;

import com.auth.auth.dto.UserLoginRequest;
import com.auth.auth.models.User;
import com.auth.auth.repository.UserRepository;
import com.auth.auth.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = jwtUtil.generateToken(user.getUsername());
                return ResponseEntity.ok(token);
            }
        }

        return ResponseEntity.badRequest().body("Invalid username or password");
    }
}
