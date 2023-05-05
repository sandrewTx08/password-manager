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
    private ObjectId _id;

    @DBRef
    @Indexed
    @NonNull
    private User user;

    @NonNull
    private String website;

    private String username;

    @NonNull
    private String password;

    private Date updated;
}
