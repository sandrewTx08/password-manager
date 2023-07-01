package com.sandrewTx08.passwordmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userdetails")
class UserDetailsController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping()
    public UserDetailsDTO getPrincipal() {
        return new UserDetailsDTO(userDetailsServiceImpl.getPrincipal());
    }
}
