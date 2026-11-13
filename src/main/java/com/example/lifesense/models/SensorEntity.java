package com.example.lifesense.models;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

/**
    * SensorEntity represents a sensor that belongs to a user. It contains information about the sensor's name, type, and unit of measurement.
 */

@Entity
public class SensorEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String name;

    private String type;

    private String unit;

    @Column(name = "api_key")
    private String apiKey;

    public SensorEntity() {
    }

    public SensorEntity(String id, UserEntity user, String name, String type, String unit, String apiKey) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.apiKey = apiKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
