package com.passwordmanager.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.passwordmanager.models.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, ObjectId> {
}
