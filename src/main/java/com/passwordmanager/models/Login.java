package com.passwordmanager.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import lombok.Data;

@Document
@Data
public class Login {
    @Id
    ObjectId _id;

    @DBRef
    User user;

    @NonNull
    String website;

    String username;

    @NonNull
    String password;
}
