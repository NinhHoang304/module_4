package com.example.completefinalexam.service.impl;

import com.example.completefinalexam.model.CoachType;
import com.example.completefinalexam.repository.ICoachTypeRepository;
import com.example.completefinalexam.service.ICoachTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachTypeServiceImpl implements ICoachTypeService {
    @Autowired
    private ICoachTypeRepository coachTypeRepository;


    @Override
    public List<CoachType> getAllCoachType() {
        return this.coachTypeRepository.getAllCoachType();
    }
}
