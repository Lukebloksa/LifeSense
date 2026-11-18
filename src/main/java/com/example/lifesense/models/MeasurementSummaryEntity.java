package com.example.lifesense.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/*
 * MeasurementSummaryEntity represents a summary of measurement - There will be average value per hour, max and min value in past hour
 */

@Entity
public class MeasurementSummaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", nullable = false)
    private SensorEntity sensorId;

    private Double avgValue;

    private Double minValue;

    private Double maxValue;

    @Column(name = "measured_at_perHour", nullable = false, updatable = false)
    private LocalDateTime hourTimestamp;

    public MeasurementSummaryEntity() {
    }

    public MeasurementSummaryEntity(Long id, SensorEntity sensorId, Double avgValue, Double minValue, Double maxValue, LocalDateTime hourTimestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.avgValue = avgValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.hourTimestamp = hourTimestamp;
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

    public Double getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(Double avgValue) {
        this.avgValue = avgValue;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public LocalDateTime getHourTimestamp() {
        return hourTimestamp;
    }

    public void setHourTimestamp(LocalDateTime hourTimestamp) {
        this.hourTimestamp = hourTimestamp;
    }
}
