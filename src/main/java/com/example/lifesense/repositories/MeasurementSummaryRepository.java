package com.example.lifesense.repositories;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.models.MeasurementSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementSummaryRepository extends JpaRepository<MeasurementSummaryEntity, Long> {


}
