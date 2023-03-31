package com.passwordmanager.models;

import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import lombok.Data;

@Document
@Data
public class User {
    @Id
    ObjectId _id;

    @NonNull
    String email;

    @NonNull
    String password;

    public void setHashPassword() {
        setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
    }
}
