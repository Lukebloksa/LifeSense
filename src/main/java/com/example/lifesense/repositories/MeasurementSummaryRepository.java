package com.example.lifesense.repositories;

import com.example.lifesense.models.MeasurementSummaryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeasurementSummaryRepository extends JpaRepository<MeasurementSummaryEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO measurement_summary_entity (sensor_id, avg_value, min_value, max_value, measured_at_per_hour) SELECT sensor_id, AVG(value), MIN(value), MAX(value), DATE_FORMAT(measured_at, '%Y-%m-%d %H:00:00') FROM measurement_entity WHERE measured_at >= DATE_SUB(NOW(), INTERVAL 1 HOUR) GROUP BY sensor_id, DATE_FORMAT(measured_at, '%Y-%m-%d %H:00:00');", nativeQuery = true)
    void calculateMeasurementSummary();

    @Query(value = "SELECT MSE.id, MSE.sensor_id, MSE.avg_value, MSE.measured_at_per_hour FROM measurement_summary_entity AS MSE WHERE measured_at_per_hour >= DATE_SUB(NOW(), INTERVAL 1 WEEK) AND MSE.sensor_id = :sensorId AND MSE.user_id = :userId;", nativeQuery = true)
    List<MeasurementSummaryEntity> weeklyMeasurements(String userId, String sensorId);
}
