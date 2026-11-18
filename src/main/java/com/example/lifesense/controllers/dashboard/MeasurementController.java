package com.example.lifesense.controllers.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.services.dashboard.MeasurementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/measurement/sensor/{sensorId}")
    public MeasurementEntity getLatestMeasurement(@RequestParam String userId, @PathVariable String sensorId) {
        return measurementService.getLatestMeasurements(userId, sensorId);
    }
}