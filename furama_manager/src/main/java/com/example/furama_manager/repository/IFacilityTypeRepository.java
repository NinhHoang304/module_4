package com.example.furama_manager.repository;

import com.example.furama_manager.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
