package com.example.lifesense.repositories;

import com.example.lifesense.models.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Transactional
    UserEntity findByEmail(String email);
}
