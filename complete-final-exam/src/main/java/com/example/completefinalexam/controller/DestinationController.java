package com.example.completefinalexam.controller;

import com.example.completefinalexam.model.Destination;
import com.example.completefinalexam.service.IDestinationService;
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
@RequestMapping("/api/destination")
public class DestinationController {
    @Autowired
    private IDestinationService destinationService;

    @GetMapping("")
    public ResponseEntity<List<Destination>> getAllDestination() {
        List<Destination> destinationList = this.destinationService.getAllDestination();
        if (destinationList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinationList, HttpStatus.OK);
    }
}
