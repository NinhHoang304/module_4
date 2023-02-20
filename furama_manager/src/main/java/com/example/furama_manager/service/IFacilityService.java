package com.example.furama_manager.service;

import com.example.furama_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> getAllAndSearch(String name, String id, Pageable pageable);

    Facility findById(int id);

    void save(Facility facility);
}
