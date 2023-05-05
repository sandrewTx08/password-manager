package com.passwordmanager.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmanager.models.Login;
import com.passwordmanager.services.LoginService;

@RestController
@RequestMapping("login/{loginId}")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @DeleteMapping
    public void deleteById(
            @PathVariable ObjectId loginId) {
        loginService.deleteById(loginId);
    }

    @PatchMapping
    public Boolean updateLogin(
            @PathVariable ObjectId loginId,
            @Validated @RequestBody Login login) {
        return loginService.updateLogin(loginId, login);
    }
}
