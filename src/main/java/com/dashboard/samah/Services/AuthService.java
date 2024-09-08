package com.dashboard.samah.Services;

import com.dashboard.samah.Entities.User;
import com.dashboard.samah.Repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }

    public void registerUser(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public void initializeDefaultUser() {
        if (userRepository.count() == 0) {
            registerUser("admin", "password"); // Default admin credentials
        }
    }
}
