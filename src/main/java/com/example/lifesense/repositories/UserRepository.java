package com.example.lifesense.repositories;

import com.example.lifesense.models.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional
    UserEntity findByEmail(String email);

}
