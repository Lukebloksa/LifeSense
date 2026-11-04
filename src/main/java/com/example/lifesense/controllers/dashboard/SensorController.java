package com.example.lifesense.controllers.dashboard;

import com.example.lifesense.models.SensorEntity;
import com.example.lifesense.repositories.SensorRepository;
import com.example.lifesense.services.dashboard.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class SensorController {

    private SensorService sensorService;

    private SensorRepository sensorRepository;

    @GetMapping("/sensors")
    public List<SensorEntity> getSensors(@RequestBody String userId) {
        return sensorService.getSensors(userId);
    }
}
