package com.passwordmanager.repositories;

import java.util.Date;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.passwordmanager.models.Login;

@Repository
public class LoginRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<Login> updateLogin(ObjectId loginId, Login login) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(loginId));

        Update update = new Update();

        if (login.getWebsite() != null)
            update.set("website", login.getWebsite());
        if (login.getUsername() != null)
            update.set("username", login.getUsername());
        if (login.getPassword() != null)
            update.set("password", login.getPassword());

        update.set("updated", new Date());

        return Optional.of(mongoTemplate.findAndModify(query, update, Login.class));
    }
}
