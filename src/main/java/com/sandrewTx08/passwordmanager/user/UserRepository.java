package com.sandrewTx08.passwordmanager.user;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    public Boolean existsByEmail(String userEmail);

    public Optional<User> findByEmail(String userEmail);
}
