package com.passwordmanager.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.models.Login;
import com.passwordmanager.repositories.LoginRepository;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public void deleteById(ObjectId loginId) {
        loginRepository.deleteById(loginId);
    }

    public Login updateLogin(ObjectId loginId, Login login) {
        Login loginById = loginRepository.findById(loginId).orElseThrow();

        loginById.setWebsite(login.getWebsite());
        loginById.setUsername(login.getUsername());
        loginById.setPassword(login.getPassword());

        loginRepository.deleteById(loginId);

        return loginRepository.insert(loginById);
    }
}
