package com.passwordmanager.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.models.Login;
import com.passwordmanager.models.User;
import com.passwordmanager.repositories.UserLoginRepository;
import com.passwordmanager.repositories.UserRepository;

@Service
public class UserLoginService {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Login> findUserLogins(ObjectId userId) {
        return userLoginRepository.findUserLogins(userId);
    }

    public Login createUserLogin(ObjectId userId, Login login) {
        User user = userRepository.findById(userId).orElseThrow();

        login.setUser(user);

        return userLoginRepository.insert(login);
    }
}
