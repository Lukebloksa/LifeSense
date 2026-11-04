package com.example.lifesense.services.dashboard;

import com.example.lifesense.models.SensorEntity;

import java.util.List;

public interface SensorService {

    /*
     * Gets sensors for user
     */
    List<SensorEntity> getSensors(String userId);

}
