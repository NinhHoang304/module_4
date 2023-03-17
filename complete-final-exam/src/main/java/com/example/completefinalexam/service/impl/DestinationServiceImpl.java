package com.example.completefinalexam.service.impl;

import com.example.completefinalexam.model.Destination;
import com.example.completefinalexam.repository.IDestinationRepository;
import com.example.completefinalexam.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements IDestinationService {
    @Autowired
    private IDestinationRepository destinationRepository;
    @Override
    public List<Destination> getAllDestination() {
        return this.destinationRepository.findAll();
    }
}
