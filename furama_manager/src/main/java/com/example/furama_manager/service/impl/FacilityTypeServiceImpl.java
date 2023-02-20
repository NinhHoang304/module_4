package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.FacilityType;
import com.example.furama_manager.repository.IFacilityTypeRepository;
import com.example.furama_manager.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return this.facilityTypeRepository.findAll();
    }
}
