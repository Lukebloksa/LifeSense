package com.example.lifesense.repositories;

import com.example.lifesense.models.MeasurementSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MeasurementSummaryRepository extends JpaRepository<MeasurementSummaryEntity, Long> {

    @Modifying
    @Query("INSERT INTO measurement_summary_entity (sensor_id, avg_value, min_value, max_value, measured_at_per_hour)\n" +
            "SELECT sensor_id, AVG(value), MIN(value), MAX(value), DATE_FORMAT(measured_at, '%Y-%m-%d %H:00:00')\n" +
            "FROM measurement_entity\n" +
            "WHERE measured_at >= DATE_SUB(NOW(), INTERVAL 1 HOUR)\n" +
            "GROUP BY sensor_id, DATE_FORMAT(measured_at, '%Y-%m-%d %H:00:00');\n")
    MeasurementSummaryEntity calculateMeasurementSummary();
}
