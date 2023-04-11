package com.passwordmanager.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.passwordmanager.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Boolean existsByEmail(String email);
}
