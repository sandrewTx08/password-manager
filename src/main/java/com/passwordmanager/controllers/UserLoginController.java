package com.passwordmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmanager.models.Login;
import com.passwordmanager.services.UserLoginService;

@RestController
@RequestMapping("user/{userId}/login")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @GetMapping
    public List<Optional<Login>> findUserLogins(
            @PathVariable("userId") ObjectId userId) {
        return userLoginService.findUserLogins(userId);
    }

    @PutMapping
    public Login createUserLogin(
            @PathVariable("userId") ObjectId userId,
            @Validated @RequestBody Login login) {
        return userLoginService.createUserLogin(userId, login);
    }
}
