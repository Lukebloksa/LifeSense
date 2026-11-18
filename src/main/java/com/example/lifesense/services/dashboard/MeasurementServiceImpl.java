package com.example.lifesense.services.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.models.MeasurementSummaryEntity;
import com.example.lifesense.repositories.MeasurementRepository;
import com.example.lifesense.repositories.MeasurementSummaryRepository;
import com.example.lifesense.repositories.SensorRepository;
import com.example.lifesense.repositories.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final UserRepository userRepository;

    private final MeasurementRepository measurementRepository;

    private final MeasurementSummaryRepository measurementSummaryRepository;

    private final SensorRepository sensorRepository;

    public MeasurementServiceImpl(UserRepository userRepository, MeasurementRepository measurementRepository, MeasurementSummaryRepository measurementSummaryRepository, SensorRepository sensorRepository) {
        this.userRepository = userRepository;
        this.measurementRepository = measurementRepository;
        this.measurementSummaryRepository = measurementSummaryRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public MeasurementEntity getLatestMeasurements(String userId, String sensorId) {
        MeasurementEntity measurements = new MeasurementEntity();
        measurementRepository.findByUserId_IdAndSensorId_Id(userId, sensorId);
        return measurements;
    }

    @Override
    public List<MeasurementSummaryEntity> getWeeklyMeasurements(String userId, String sensorId) {
        return measurementSummaryRepository.weeklyMeasurements(userId, sensorId);
    }

    @Override
    @Scheduled(cron = "0 0 * * * *")
    public void getMeasurementSummary() {
        measurementSummaryRepository.calculateMeasurementSummary();
    }

}
