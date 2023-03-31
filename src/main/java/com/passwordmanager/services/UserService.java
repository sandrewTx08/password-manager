package com.passwordmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.models.User;
import com.passwordmanager.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User newUser) {
        User user = userRepository.findUserByEmail(newUser.getEmail());

        if (user == null) {
            newUser.setHashPassword();
            userRepository.save(newUser);
            return newUser;
        }

        return user;
    }
}
