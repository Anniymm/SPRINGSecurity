package com.auth.auth.models;


import jakarta.persistence.*;
import lombok.*;

//used for authentication and storing user details
//The data from the User.java model is stored in the database during user registration, retrieved from the database during login, and then used to validate the user's identity and permissions via Spring Security and JWT.
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;
    // aq aghar minda confirm password, bazashi shenaxva ar unda (wesit)

    private String role;
}