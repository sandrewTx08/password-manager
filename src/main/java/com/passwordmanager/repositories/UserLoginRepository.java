package com.passwordmanager.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.passwordmanager.models.Login;

public interface UserLoginRepository extends MongoRepository<Login, ObjectId> {
    @Query("{'user.$id': ?0}")
    public List<Login> findUserLogins(ObjectId userId);
}
