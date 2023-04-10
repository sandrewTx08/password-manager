package com.passwordmanager.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
@Data
public class Login {
    @Id
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
}
