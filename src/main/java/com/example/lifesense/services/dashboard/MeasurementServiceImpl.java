package com.example.lifesense.services.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.models.SensorEntity;
import com.example.lifesense.repositories.MeasurementRepository;
import com.example.lifesense.repositories.SensorRepository;
import com.example.lifesense.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final UserRepository userRepository;

    private final MeasurementRepository measurementRepository;

    private final SensorRepository sensorRepository;

    public MeasurementServiceImpl(UserRepository userRepository, MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.userRepository = userRepository;
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public MeasurementEntity getLatestMeasurements(String userId, String sensorId) {
        MeasurementEntity measurements = new MeasurementEntity();
        measurementRepository.findByUserId_IdAndSensorId_Id(userId, sensorId);
        return measurements;
    }

    @Override
    public MeasurementEntity getMeasurement(String userId, String sensorId) {
        MeasurementEntity measurements = new MeasurementEntity();
        return measurements;
    }

}
