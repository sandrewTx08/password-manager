package com.passwordmanager.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmanager.models.Login;
import com.passwordmanager.services.UserLoginService;

@RestController
@RequestMapping("user/{userId}")
public class UserLoginController {
    @Autowired
    UserLoginService service;

    @GetMapping
    public List<Login> findUserLogins(
            @PathVariable("userId") ObjectId userId) {
        return service.findUserLogins(userId);
    }

    @PostMapping
    public Login createUserLogin(
            @PathVariable("userId") ObjectId userId,
            @RequestBody Login login) {
        return service.createUserLogin(userId, login);
    }
}
