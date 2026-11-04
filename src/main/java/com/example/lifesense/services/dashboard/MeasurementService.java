package com.example.lifesense.services.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.models.SensorEntity;

import java.util.List;

public interface MeasurementService {
    /*
     * Gets latest measurements for every sensor.
     */
    List<MeasurementEntity> getMeasurements(String sensorId);

    /*
     *
     */
}
