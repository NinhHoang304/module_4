package com.example.completefinalexam.repository;

import com.example.completefinalexam.model.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartureRepository extends JpaRepository<Departure, Integer> {
    @Query(value = "select * from departure", nativeQuery = true)
    List<Departure> getAllDeparture();
}
