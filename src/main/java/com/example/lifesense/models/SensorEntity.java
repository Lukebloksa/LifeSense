package com.example.lifesense.models;

import jakarta.persistence.*;

/**
    * SensorEntity represents a sensor that belongs to a user. It contains information about the sensor's name, type, and unit of measurement.
 */

@Entity
public class SensorEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;

    private String name;

    private String type;

    private String unit;

    public SensorEntity(String id, UserEntity userId, String name, String type, String unit) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.unit = unit;
    }

    public SensorEntity() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
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
}
