package com.auth.auth.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Here, you would load the user from your database
        // For now, we'll return a dummy user
        return User.builder()
                .username("user")
                .password("{noop}password") // {noop} is used for plain text password (for demonstration)
                .roles("USER")
                .build();
    }
}
