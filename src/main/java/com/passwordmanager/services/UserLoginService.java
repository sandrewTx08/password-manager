package com.passwordmanager.services;

import java.util.List;
import java.util.Optional;

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
    UserLoginRepository loginRepository;

    @Autowired
    UserRepository userRepository;

    public List<Optional<Login>> findUserLogins(ObjectId userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return loginRepository.findUserLogins(user.get_id());
    }

    public Login createUserLogin(ObjectId userId, Login login) {
        User user = userRepository.findById(userId).orElseThrow();

        login.setUser(user);

        return loginRepository.insert(login);
    }
}
