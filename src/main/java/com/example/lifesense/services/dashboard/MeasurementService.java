package com.example.lifesense.services.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.models.MeasurementSummaryEntity;
import com.example.lifesense.models.SensorEntity;

import java.util.List;

public interface MeasurementService {
    /*
     * Gets latest measurements for every sensor.
     */
    MeasurementEntity getLatestMeasurements(String userId, String sensorId);

    /*
     * Gets weekly measurements from sensor
     */
    List<MeasurementEntity> getWeeklyMeasurements(String userId, String sensorId);

    /*
     * Calculates measurement summary for a given user and sensor.
     */
    void getMeasurementSummary(String userId, String sensorId);
}
