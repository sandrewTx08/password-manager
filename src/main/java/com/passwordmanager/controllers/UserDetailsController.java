package com.passwordmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmanager.models.UserDetailsImpl;
import com.passwordmanager.repositories.UserRepository;

@RestController
@RequestMapping("userdetails")
public class UserDetailsController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public UserDetailsImpl getUser() {
        try {
            UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            userDetails.setUser(userRepository
                    .findByEmail(userDetails.getUsername())
                    .orElseThrow());

            return userDetails;
        } catch (Exception exception) {
            return null;
        }
    }
}
