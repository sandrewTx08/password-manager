package com.passwordmanager.services;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passwordmanager.models.Login;
import com.passwordmanager.repositories.LoginRepository;
import com.passwordmanager.repositories.LoginRepositoryImpl;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginRepositoryImpl loginRepositoryImpl;

    public void deleteById(ObjectId loginId) {
        loginRepository.deleteById(loginId);
    }

    public Optional<Login> updateLogin(ObjectId loginId, Login login) {
        return loginRepositoryImpl.updateLogin(loginId, login);
    }
}
