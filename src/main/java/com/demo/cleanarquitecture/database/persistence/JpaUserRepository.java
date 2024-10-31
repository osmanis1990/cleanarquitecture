package com.demo.cleanarquitecture.database.persistence;

import com.demo.cleanarquitecture.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}