package com.example.furama_manager.service;

import com.example.furama_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService {
    Page<Facility> getAllFacilityByQuery(String name, String facilityTypeName, Pageable pageable);
    Page<Facility> getAllAndSearch(String name, String id, Pageable pageable);

    List<Facility> findAll();

    Facility findById(int id);

    void save(Facility facility);
}
