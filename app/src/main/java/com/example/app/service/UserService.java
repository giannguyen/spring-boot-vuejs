package com.example.app.service;

import com.example.app.model.User;

public interface UserService {
    User createUser(User user);

    User findByUserName(String username);
}
