package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.RentType;
import com.example.furama_manager.repository.IRentTypeRepository;
import com.example.furama_manager.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeRepositoryImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
