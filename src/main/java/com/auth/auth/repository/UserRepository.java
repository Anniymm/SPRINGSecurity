package com.auth.auth.repository;

import com.auth.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
