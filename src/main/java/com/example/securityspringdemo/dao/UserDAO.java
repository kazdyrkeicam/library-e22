package com.example.securityspringdemo.dao;

import com.example.securityspringdemo.model.AppUser;

import java.util.Optional;

public interface UserDAO {

    Optional<AppUser> selectUserByName(String username);
}
