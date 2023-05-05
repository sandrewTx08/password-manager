package com.passwordmanager.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
@Data
public class Login {
    @MongoId
    ObjectId _id;

    @DBRef
    @Indexed
    @NonNull
    User user;

    @NonNull
    String website;

    String username;

    @NonNull
    String password;

    Date updated;
}
