package com.example.lifesense.services.auth;

import javax.crypto.SecretKey;

public interface JwtService {

    String generateToken(String email);

    String extractEmail(String token);

    boolean isTokenValid(String token);
}
