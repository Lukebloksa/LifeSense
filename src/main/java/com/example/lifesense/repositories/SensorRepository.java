package com.example.lifesense.repositories;

import com.example.lifesense.models.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<SensorEntity, String> {

    List<SensorEntity> findByUser_Id(String userId);

    default List<SensorEntity> findByUserId_Id(String userId) {
        return findByUser_Id(userId);
    }
}
