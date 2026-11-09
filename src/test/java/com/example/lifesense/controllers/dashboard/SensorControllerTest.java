package com.example.lifesense.controllers.dashboard;

import com.example.lifesense.models.SensorEntity;
import com.example.lifesense.services.dashboard.SensorService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SensorControllerTest {

    @Test
    void getSensors_returnsSensorsForUser() throws Exception {
        SensorService sensorService = mock(SensorService.class);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new SensorController(sensorService)).build();

        SensorEntity sensor = new SensorEntity();
        sensor.setId("sensor-1");
        sensor.setName("Temperature Sensor");
        sensor.setType("temperature");
        sensor.setUnit("C");

        when(sensorService.getSensors("user-1")).thenReturn(List.of(sensor));

        mockMvc.perform(get("/api/dashboard/sensors/user-1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("sensor-1"))
                .andExpect(jsonPath("$[0].name").value("Temperature Sensor"))
                .andExpect(jsonPath("$[0].type").value("temperature"))
                .andExpect(jsonPath("$[0].unit").value("C"));
    }
}
