package com.example.lifesense.repositories.auth;

import com.example.lifesense.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "INSERT INTO users (id, username, email, password) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    UserEntity insert(String id, String username, String email, String password);

    UserEntity findByEmailAndPassword(String email, String password);

}
