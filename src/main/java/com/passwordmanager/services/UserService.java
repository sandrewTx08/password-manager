package com.passwordmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.exceptions.UserEmailAlreadyExists;
import com.passwordmanager.models.User;
import com.passwordmanager.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) throws UserEmailAlreadyExists {
        Boolean userByEmail = userRepository.existsByEmail(user.getEmail());

        if (!userByEmail)
            return userRepository.insert(user);

        throw new UserEmailAlreadyExists();
    }
}
