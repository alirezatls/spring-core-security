package com.sample.corespringsecurity.controller;

import com.sample.corespringsecurity.domain.User;
import com.sample.corespringsecurity.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    User map(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setReference(UUID.randomUUID().toString());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        return user;
    }

    UserResponse map(UserPrincipal user) {
        UserResponse response = new UserResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setReference(user.getReference());
        return response;
    }

}
