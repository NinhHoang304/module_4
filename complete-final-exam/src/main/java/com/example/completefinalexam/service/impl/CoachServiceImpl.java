package com.example.completefinalexam.service.impl;

import com.example.completefinalexam.model.Coach;
import com.example.completefinalexam.repository.ICoachRepository;
import com.example.completefinalexam.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements ICoachService {
    @Autowired
    private ICoachRepository coachRepository;
    @Override
    public Page<Coach> getAll(Pageable pageable) {
        return this.coachRepository.getAllCoach(pageable);
    }

    @Override
    public Coach findById(int id) {
        return this.coachRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Coach coach) {
        this.coachRepository.save(coach);
    }

    @Override
    public void update(Coach coach) {
        this.coachRepository.save(coach);
    }
}
