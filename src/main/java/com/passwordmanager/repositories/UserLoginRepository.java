package com.passwordmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.passwordmanager.models.Login;

@Repository
public interface UserLoginRepository extends MongoRepository<Login, ObjectId> {
    @Query(value = "{\"user.$id\": ?0}", fields = "{user: 0}")
    List<Optional<Login>> findUserLogins(ObjectId userId);
}
