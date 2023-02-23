package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.Facility;
import com.example.furama_manager.repository.IFacilityRepository;
import com.example.furama_manager.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class FacilityServiceImpl implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<Facility> getAllAndSearch(String name, String id, Pageable pageable) {
        return this.facilityRepository.findByNameAndFacilityTypeAndDeletedFalse(name, id, pageable);
    }

    @Override
    public List<Facility> findAll() {
        return this.facilityRepository.findAll();
    }

    @Override
    public Facility findById(int id) {
        return this.facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Facility facility) {
        this.facilityRepository.save(facility);
    }
}
