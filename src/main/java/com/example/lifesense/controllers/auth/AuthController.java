package com.example.lifesense.controllers.auth;

import com.example.lifesense.models.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/registration")
    public String registration(UserEntity user) {

        return accessToken;
    }
}
