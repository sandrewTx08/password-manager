package com.sandrewTx08.passwordmanager.user;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(ObjectId userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> findUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    public User insertUser(User user) throws UserAlreadyExistsException {
        Boolean existsByEmail = userRepository.existsByEmail(user.getEmail());

        if (!existsByEmail)
            return userRepository.insert(user);

        throw new UserAlreadyExistsException();
    }
}
