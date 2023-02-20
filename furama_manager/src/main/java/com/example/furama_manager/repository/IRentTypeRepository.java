package com.example.furama_manager.repository;

import com.example.furama_manager.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
