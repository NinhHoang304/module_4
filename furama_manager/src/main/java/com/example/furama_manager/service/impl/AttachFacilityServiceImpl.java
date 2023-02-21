package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.AttachFacility;
import com.example.furama_manager.repository.IAttachFacilityRepository;
import com.example.furama_manager.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return this.attachFacilityRepository.findAll();
    }

}
