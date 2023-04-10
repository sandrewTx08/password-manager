package com.passwordmanager.exceptions;

public class UserEmailAlreadyExists extends Exception {
    public UserEmailAlreadyExists() {
        super("Email already exists");
    }
}
