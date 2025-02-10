package com.auth.auth.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    @Bean
    public Dotenv dotenv() {
        Dotenv dotenv = Dotenv.load();

        // Set environment variables as system properties so Spring Boot can use them
        System.setProperty("POSTGRES_USER", dotenv.get("POSTGRES_USER"));
        System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));
        System.setProperty("POSTGRES_DB", dotenv.get("POSTGRES_DB"));
        System.setProperty("POSTGRES_HOST", dotenv.get("POSTGRES_HOST"));
        System.setProperty("POSTGRES_PORT", dotenv.get("POSTGRES_PORT"));

        return dotenv;
    }
}
