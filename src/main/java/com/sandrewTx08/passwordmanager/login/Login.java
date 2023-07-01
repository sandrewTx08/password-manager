package com.sandrewTx08.passwordmanager.login;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.mongodb.lang.NonNull;
import com.sandrewTx08.passwordmanager.user.User;

public class Login {
    @MongoId
    private ObjectId _id;

    @NonNull
    private String domain;

    @NonNull
    @DBRef
    private User user;

    private String username;

    @NonNull
    private String password;

    public Long getCreated_at() {
        return _id.getDate().getTime();
    }

    public String get_id() {
        return _id.toString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
