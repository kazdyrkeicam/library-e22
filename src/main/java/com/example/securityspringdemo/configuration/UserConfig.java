package com.example.securityspringdemo.configuration;

import com.example.securityspringdemo.dao.UserDAOJPA;
import com.example.securityspringdemo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static com.example.securityspringdemo.security.UserRole.ADMIN;
import static com.example.securityspringdemo.security.UserRole.STUDENT;

@Configuration
public class UserConfig {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner cmdRunUsers(UserDAOJPA userRepo) {
        return args -> {
            AppUser a = new AppUser(
                passwordEncoder.encode("123"),
                "anna",
                STUDENT
            );
            AppUser b = new AppUser(
                passwordEncoder.encode("123"),
                "linda",
                ADMIN
            );

            userRepo.saveAll(List.of(
                a, b
            ));
        };
    }
}
