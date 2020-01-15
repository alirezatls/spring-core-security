package com.sample.corespringsecurity.service;

import com.sample.corespringsecurity.domain.User;
import com.sample.corespringsecurity.security.UserPrincipal;

public interface UserService {

    void createUser(User user);

    UserPrincipal getUserByUsername(String username);

}
