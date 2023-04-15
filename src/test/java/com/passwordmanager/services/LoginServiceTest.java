package com.passwordmanager.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.passwordmanager.models.Login;
import com.passwordmanager.models.User;
import com.passwordmanager.repositories.LoginRepository;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    LoginService loginService;

    @MockBean
    LoginRepository loginRepository;

    @Test
    public void updateLogin() {
        User user = new User();
        user.setEmail("login@example.com");

        Login login1 = new Login();
        login1.set_id(new ObjectId());
        login1.setUser(user);
        login1.setWebsite("https://example.com");
        login1.setPassword("admin123");

        when(loginRepository.findById(login1.get_id())).thenReturn(Optional.of(login1));

        Login login2 = new Login();
        login1.setPassword("password123");

        Login login3 = loginService.updateLogin(login1.get_id(), login2);

        assertEquals(login1.get_id(), login3.get_id());
        assertEquals(login1.getWebsite(), login3.getWebsite());
        assertTrue(BCrypt.checkpw("password123", login3.getPassword()));
    }
}
