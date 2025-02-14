package com.auth.auth;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {

//    static {
//        Dotenv dotenv = Dotenv.load(); // Load .env variables
//        System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
//        System.setProperty("DATABASE_USER", dotenv.get("DATABASE_USER"));
//        System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));
//    }

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
