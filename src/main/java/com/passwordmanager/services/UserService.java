package com.passwordmanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.exceptions.UserEmailAlreadyExists;
import com.passwordmanager.models.User;
import com.passwordmanager.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) throws UserEmailAlreadyExists {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());

        if (userByEmail.isEmpty())
            return userRepository.insert(user);

        throw new UserEmailAlreadyExists();
    }
}
