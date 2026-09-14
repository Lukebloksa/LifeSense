package com.example.lifesense.controllers.auth;

import com.example.lifesense.models.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @PostMapping("/registration")
    public UserEntity registration(UserEntity user) {

        return user;
    }
}
