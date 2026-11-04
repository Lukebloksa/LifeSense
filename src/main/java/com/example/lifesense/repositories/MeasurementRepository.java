package com.example.lifesense.repositories;

import com.example.lifesense.models.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {
}
