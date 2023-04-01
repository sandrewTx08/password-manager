package com.passwordmanager.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.exceptions.UserInvalidId;
import com.passwordmanager.exceptions.UserNotFound;
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

    public List<Login> findUserLogins(String userId) throws Exception {
        if (!ObjectId.isValid(userId))
            throw new UserInvalidId();

        Optional<User> user = userRepository.findById(new ObjectId(userId));

        if (user.isEmpty())
            throw new UserNotFound();

        return loginRepository.findUserLogins(user.get().get_id());
    }

    public Login createUserLogin(String userId, Login login) throws Exception {
        if (!ObjectId.isValid(userId))
            throw new UserInvalidId();

        Optional<User> user = userRepository.findById(new ObjectId(userId));

        if (user.isEmpty())
            throw new UserNotFound();

        login.setUser(user.get());

        return loginRepository.save(login);
    }
}
