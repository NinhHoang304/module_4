package com.example.completefinalexam.service;

import com.example.completefinalexam.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface ICoachService {
    Page<Coach> getAll(Pageable pageable);

    Coach findById(int id);

    void save(Coach coach);

    void update(Coach coach);
}
