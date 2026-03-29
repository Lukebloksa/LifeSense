package com.example.lifesense.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * MeasurementEntity represents a measurment taken by a sensor from a user.
 */

@Entity
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", nullable = false)
    private SensorEntity sensorId;

    private Double value;

    @Column(name = "measured_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime measuredAt;

    public MeasurementEntity(Long id, SensorEntity sensorId, Double value, LocalDateTime measuredAt) {
        this.id = id;
        this.sensorId = sensorId;
        this.value = value;
        this.measuredAt = measuredAt;
    }

    public MeasurementEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SensorEntity getSensorId() {
        return sensorId;
    }

    public void setSensorId(SensorEntity sensorId) {
        this.sensorId = sensorId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getMeasuredAt() {
        return measuredAt;
    }

    public void setMeasuredAt(LocalDateTime measuredAt) {
        this.measuredAt = measuredAt;
    }
}
