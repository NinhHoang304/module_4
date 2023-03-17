package com.example.completefinalexam.repository;

import com.example.completefinalexam.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICoachRepository extends JpaRepository<Coach, Integer> {
    @Query(value = "select * from coach where deleted = false", nativeQuery = true)
    Page<Coach> getAllCoach(Pageable pageable);
}
