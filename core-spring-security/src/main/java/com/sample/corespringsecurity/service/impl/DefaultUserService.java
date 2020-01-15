package com.sample.corespringsecurity.service.impl;

import com.sample.corespringsecurity.domain.User;
import com.sample.corespringsecurity.repository.UserRepository;
import com.sample.corespringsecurity.security.CustomUserDetailService;
import com.sample.corespringsecurity.security.UserPrincipal;
import com.sample.corespringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
    private UserRepository repository;
    private CustomUserDetailService userDetailService;

    @Autowired
    public DefaultUserService(UserRepository repository, CustomUserDetailService userDetailService) {
        this.repository = repository;
        this.userDetailService = userDetailService;
    }

    @Override
    public void createUser(User user) {
        repository.save(user);
    }

    @Override
    public UserPrincipal getUserByUsername(String username) {
        return (UserPrincipal) userDetailService.loadUserByUsername(username);
    }
}
