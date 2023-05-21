package com.sandrewTx08.passwordmanager.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mongodb.lang.NonNull;

public class User {
    @MongoId
    private ObjectId _id;

    @NonNull
    private String email;

    @NonNull
    private String password;

    public String get_id() {
        return _id.toString();
    }

    public void set_id(ObjectId _Id) {
        this._id = _Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
