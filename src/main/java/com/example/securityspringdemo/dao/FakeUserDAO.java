package com.example.securityspringdemo.dao;

import com.example.securityspringdemo.model.AppUser;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.securityspringdemo.security.UserRole.*;


@Repository("fake")
public class FakeUserDAO implements UserDAO {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserDAO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectUserByName(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getApplicationUsers() {
        List<AppUser> appUsers = Lists.newArrayList(
                new AppUser(
                        passwordEncoder.encode("123"),
                        "anna",
                         STUDENT
                ),
                new AppUser(
                        passwordEncoder.encode("123"),
                        "linda",
                        ADMIN
                )
        );

        return appUsers;
    }
}
