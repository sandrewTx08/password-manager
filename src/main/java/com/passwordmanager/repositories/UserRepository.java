package com.passwordmanager.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.passwordmanager.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email: ?0}")
    Optional<User> findUserByEmail(String email);
}
