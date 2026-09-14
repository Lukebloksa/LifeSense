package com.example.lifesense.services.auth;

import com.example.lifesense.models.UserEntity;

public interface AuthService {

    /*
     * Registration of a new user (Username, Email and Password)
     */
    UserEntity registration(UserEntity user);

    /*
     * Login of an existing user (Email and Password)
     */
    UserEntity login(String email, String password);

}
