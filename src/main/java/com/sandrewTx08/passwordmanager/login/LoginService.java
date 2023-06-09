package com.sandrewTx08.passwordmanager.login;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> findAllLoginsByUser(ObjectId userId) {
        return loginRepository.findAllLoginsByUser(userId);
    }

    public Login insertLogin(Login login) {
        return loginRepository.insert(login);
    }

    public Login updateLogin(Login login) {
        loginRepository.delete(login);
        return loginRepository.save(login);
    }

    public void deleteLogin(Login login) {
        loginRepository.delete(login);
    }
}
