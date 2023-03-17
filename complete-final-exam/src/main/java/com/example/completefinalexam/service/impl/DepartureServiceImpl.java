package com.example.completefinalexam.service.impl;

import com.example.completefinalexam.model.Departure;
import com.example.completefinalexam.repository.IDepartureRepository;
import com.example.completefinalexam.service.IDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureServiceImpl implements IDepartureService {
    @Autowired
    private IDepartureRepository departureRepository;
    @Override
    public List<Departure> getAllDeparture() {
        return this.departureRepository.findAll();
    }
}
