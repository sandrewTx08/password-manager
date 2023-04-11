package com.passwordmanager.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.passwordmanager.models.Login;

public interface LoginRepository extends MongoRepository<Login, ObjectId> {
}
