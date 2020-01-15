package com.sample.corespringsecurity.controller;

import com.sample.corespringsecurity.domain.User;
import com.sample.corespringsecurity.security.UserPrincipal;
import com.sample.corespringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserRegisterController {

    private UserService service;
    private UserMapper mapper;

    @Autowired
    public UserRegisterController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/api/user/register")
    public void register(@RequestBody @Valid UserRequest userRequest) {
        User user = mapper.map(userRequest);
        service.createUser(user);
    }

    @GetMapping("/api/user/{username}")
    public UserResponse get(@PathVariable("username") String username) {
        UserPrincipal principal = service.getUserByUsername(username);
        return mapper.map(principal);
    }
}
