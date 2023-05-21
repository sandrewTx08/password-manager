package com.sandrewTx08.passwordmanager.login;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandrewTx08.passwordmanager.user.UserDetailsServiceImpl;

@RestController
@RequestMapping("logins")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping
    public List<Login> findAllLoginsByUser() {
        return loginService.findAllLoginsByUser(
                new ObjectId(
                        userDetailsServiceImpl
                                .getPrincipal()
                                .getUser()
                                .get_id()));
    }

    @PostMapping
    public Login insertLogin(@Validated @RequestBody Login login) {
        login.setUser(userDetailsServiceImpl
                .getPrincipal()
                .getUser());

        return loginService.insertLogin(login);
    }
}
