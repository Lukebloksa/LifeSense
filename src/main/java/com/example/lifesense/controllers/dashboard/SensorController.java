package com.example.lifesense.controllers.dashboard;

import com.example.lifesense.models.SensorEntity;
import com.example.lifesense.services.dashboard.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/sensors/{userId}")
    public List<SensorEntity> getSensors(@PathVariable String userId) {
        return sensorService.getSensors(userId);
    }
}
