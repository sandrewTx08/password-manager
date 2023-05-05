package com.passwordmanager.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.passwordmanager.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    public Boolean existsByEmail(String email);

    public Optional<User> findByEmail(String email);
}
