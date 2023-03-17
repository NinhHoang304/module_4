package com.example.completefinalexam.controller;

import com.example.completefinalexam.model.Departure;
import com.example.completefinalexam.service.IDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/departure")
public class DepartureController {
    @Autowired
    private IDepartureService departureService;

    @GetMapping("")
    public ResponseEntity<List<Departure>> getAllDeparture() {
        List<Departure> departureList = this.departureService.getAllDeparture();
        if (departureList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departureList, HttpStatus.OK);
    }
}
