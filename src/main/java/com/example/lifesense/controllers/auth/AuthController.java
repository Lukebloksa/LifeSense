package com.example.lifesense.controllers.auth;

import com.example.lifesense.configurations.JwtAuthFilter;
import com.example.lifesense.models.UserEntity;
import com.example.lifesense.services.auth.AuthService;
import com.example.lifesense.services.auth.JwtServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtServiceImpl jwtServiceImpl;

    public AuthController(AuthService authService, JwtServiceImpl jwtServiceImpl) {
        this.authService = authService;
        this.jwtServiceImpl = jwtServiceImpl;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody UserEntity user) {
        authService.registration(user);
        return jwtServiceImpl.generateToken(user.getEmail());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user) {
        UserEntity authenticated = authService.login(user.getEmail(), user.getPassword());
        if (authenticated == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        return ResponseEntity.ok(jwtServiceImpl.generateToken(authenticated.getEmail()));
    }
}
