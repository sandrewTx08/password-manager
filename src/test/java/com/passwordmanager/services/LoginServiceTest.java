package com.passwordmanager.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Optional;

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
import com.passwordmanager.repositories.LoginRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginRepository loginRepository;

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
    public void updateLogin() {
        Login update = new Login();
        update.setWebsite("example.com");

        Date updated = new Date();
        loginService.updateLogin(login.get_id(), update);

        Optional<Login> updatedLogin = loginRepository.findById(login.get_id());

        assertEquals(updatedLogin.orElseThrow().getWebsite(), update.getWebsite());
        assertEquals(updatedLogin.orElseThrow().getUpdated().toString(), updated.toString());
    }
}
