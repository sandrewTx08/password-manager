package com.passwordmanager.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.passwordmanager.models.Login;

public interface UserLoginRepository extends MongoRepository<Login, ObjectId> {
    @Query(value = "{'user.$id': ?0}", fields = "{user: 0}")
    public List<Login> findUserLogins(ObjectId userId);
}
