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
        Query query = new Query()
                .addCriteria(Criteria
                        .where("_id")
                        .is(loginId));

        Optional<Login> loginById = Optional.of(
                mongoTemplate
                        .findOne(query, Login.class));

        if (loginById.isPresent()) {
            Update update = new Update();

            if (login.getDomain() != null)
                update.set("domain", login.getDomain());
            else
                update.set("domain", loginById.get().getDomain());

            if (login.getUsername() != null)
                update.set("username", login.getUsername());
            else
                update.set("username", loginById.get().getUsername());

            if (login.getPassword() != null)
                update.set("password", login.getPassword());
            else
                update.set("password", loginById.get().getPassword());

            update.set("user", loginById.get().getUser());
            update.set("updated", new Date());

            return Optional.of(mongoTemplate.findAndModify(query, update, Login.class));
        }

        return loginById;
    }
}
