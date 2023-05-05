package com.passwordmanager.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.passwordmanager.models.Login;
import com.passwordmanager.models.User;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserLoginServiceTest {
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final Login login = new Login();
    private final User user = new User();

    @BeforeAll
    public void beforeAll() {
        user.set_id(new ObjectId());
        user.setEmail("login@example.com");
        user.setPassword("password123");

        mongoTemplate.save(user);

        login.setUser(user);
        login.setWebsite("https://example.com");
        login.setPassword("admin123");

        mongoTemplate.save(login);
    }

    @AfterAll
    public void afterAll() {
        mongoTemplate.remove(user);
        mongoTemplate.remove(login);
    }

    @Test
    public void findUserLogins() {
        List<Login> userLogins = userLoginService.findUserLogins(user.get_id());

        assertEquals(login.get_id(), userLogins.get(0).get_id());
    }
}
