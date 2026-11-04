package com.example.lifesense.services.dashboard;

import com.example.lifesense.models.SensorEntity;
import com.example.lifesense.repositories.MeasurementRepository;
import com.example.lifesense.repositories.SensorRepository;
import com.example.lifesense.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final UserRepository userRepository;

    private final MeasurementRepository measurementRepository;

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(UserRepository userRepository, MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.userRepository = userRepository;
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<SensorEntity> getSensors(String userId) {
        List<SensorEntity> sensors = new ArrayList<>();
        sensors.addAll(sensorRepository.findByUserId(userId));
        return sensors;
    }
}
