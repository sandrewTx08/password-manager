package com.sandrewTx08.passwordmanager.user;

import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsDTO {
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetailsDTO(UserDetails userDetails) {
        this.email = userDetails.getUsername();
    }
}
