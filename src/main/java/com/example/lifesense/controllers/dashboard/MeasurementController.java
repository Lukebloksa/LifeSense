package com.example.lifesense.controllers.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.services.dashboard.MeasurementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/measurement/{userId}/sensor/{sensorId}")
    public MeasurementEntity getLatestMeasurement(@PathVariable String userId, @PathVariable String sensorId) {
        return measurementService.getLatestMeasurements(userId, sensorId);
    }
}