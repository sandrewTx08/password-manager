package com.passwordmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmanager.exceptions.UserEmailAlreadyExists;
import com.passwordmanager.models.User;
import com.passwordmanager.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@Validated @RequestBody User user) throws UserEmailAlreadyExists {
        return userService.createUser(user);
    }
}
