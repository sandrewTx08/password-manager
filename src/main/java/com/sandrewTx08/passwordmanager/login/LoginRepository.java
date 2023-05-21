package com.sandrewTx08.passwordmanager.login;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LoginRepository extends MongoRepository<Login, ObjectId> {
    @Query(value = "{'user.$id': ?0}", fields = "{'user': 0}")
    public List<Login> findAllLoginsByUser(ObjectId userId);
}
