package com.passwordmanager.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.passwordmanager.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email: ?0}")
    User findUserByEmail(String email);
}
