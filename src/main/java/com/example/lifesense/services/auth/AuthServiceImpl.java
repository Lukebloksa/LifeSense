package com.example.lifesense.services.auth;

import com.example.lifesense.models.UserEntity;

public class AuthServiceImpl implements AuthService {


    @Override
    public UserEntity registration(UserEntity user) {



        return user;
    }

    @Override
    public UserEntity login(String email, String password) {
        return null;
    }
}
