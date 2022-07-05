package com.example.securityspringdemo.dao;

import com.example.securityspringdemo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("main")
public class UserDAOJPA implements UserDAO {

    private final UserRepo userRepo;

    @Autowired
    public UserDAOJPA(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Optional<AppUser> selectUserByName(String username) {
        return userRepo.findAppUserByUsername(username);
    }

    public void saveAll(List<AppUser> list) {
        userRepo.saveAll(list);
    }
}
