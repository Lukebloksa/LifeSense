package com.example.lifesense.services.auth;

import com.example.lifesense.models.UserEntity;
import com.example.lifesense.repositories.auth.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    @Override
    public UserEntity registration(UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userRepository.insert(user.getId(), user.getUsername(), user.getEmail(), encodedPassword);
        return user;
    }

    @Override
    public UserEntity login(String email, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity user = userRepository.findByEmailAndPassword(email, password);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
