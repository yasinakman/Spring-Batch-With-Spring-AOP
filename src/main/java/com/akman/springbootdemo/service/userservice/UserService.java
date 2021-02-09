package com.akman.springbootdemo.service.userservice;

import com.akman.springbootdemo.model.User;

import java.util.List;

public interface UserService {
    User saveUser();

    List<User> listUsers();
}