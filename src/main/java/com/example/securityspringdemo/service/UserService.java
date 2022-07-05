package com.example.securityspringdemo.service;

import com.example.securityspringdemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("main") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.selectUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User %s not found", username))
                );
    }
}
