package com.example.lifesense.models;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * UserEntity represents a user of the application. Contains information about the user
 */

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    private String username;

    private String email;

    private String password;

    @Column(name = "api_key", length = 36, unique = true)
    private String apiKey;

    public UserEntity(String id, String username, String email, String password, String apiKey) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.apiKey = apiKey;
    }

    public UserEntity() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
