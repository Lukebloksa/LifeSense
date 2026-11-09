package com.example.lifesense.controllers.dashboard;

import com.example.lifesense.models.MeasurementEntity;
import com.example.lifesense.services.dashboard.MeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MeasurementControllerTest {

    @Test
    void getLatestMeasurement_returnsMeasurementForSensor() throws Exception {
        MeasurementService measurementService = mock(MeasurementService.class);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MeasurementController(measurementService)).build();

        MeasurementEntity measurement = new MeasurementEntity();
        measurement.setId(1L);
        measurement.setValue(22.5);
        measurement.setMeasuredAt(LocalDateTime.of(2026, 11, 5, 12, 30));

        when(measurementService.getLatestMeasurements("user-1", "sensor-1")).thenReturn(measurement);

        mockMvc.perform(get("/api/dashboard/measurement/user-1/sensor/sensor-1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.value").value(22.5))
                .andExpect(jsonPath("$.measuredAt").value("2026-11-05T12:30:00"));
    }
}
