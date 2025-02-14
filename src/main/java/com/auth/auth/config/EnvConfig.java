package com.auth.auth.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    @Bean
    public Dotenv dotenv() {
        Dotenv dotenv = Dotenv.configure()
                .directory("./")  // Ensure it's pointing to the correct directory
                .ignoreIfMissing()
                .load();
        return dotenv;
    }
}
