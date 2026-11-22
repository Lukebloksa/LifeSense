package com.example.lifesense.repositories;

import com.example.lifesense.models.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {

    MeasurementEntity findFirstBySensorId_User_IdAndSensorId_IdOrderByMeasuredAtDesc(String userId, String sensorId);

    default MeasurementEntity findByUserId_IdAndSensorId_Id(String userId, String sensorId) {
        return findFirstBySensorId_User_IdAndSensorId_IdOrderByMeasuredAtDesc(userId, sensorId);
    }
}
