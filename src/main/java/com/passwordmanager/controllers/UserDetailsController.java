package com.passwordmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmanager.models.User;
import com.passwordmanager.repositories.UserRepository;

@RestController
@RequestMapping("userdetails")
public class UserDetailsController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public User getUser() {
        return userRepository
                .findByEmail(((UserDetails) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal()).getUsername())
                .orElseThrow();
    }
}
