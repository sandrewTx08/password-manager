package com.passwordmanager.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.models.Login;
import com.passwordmanager.models.User;
import com.passwordmanager.repositories.LoginRepository;
import com.passwordmanager.repositories.UserRepository;

@Service
public class UserLoginService {
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserRepository userRepository;

    public List<Login> findUserLogins(ObjectId userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty())
            return null;

        return loginRepository.findUserLogins(user.get().get_id());
    }

    public Login createUserLogin(ObjectId userId, Login login) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty())
            return null;

        login.setUser(user.get());

        return loginRepository.save(login);
    }
}
