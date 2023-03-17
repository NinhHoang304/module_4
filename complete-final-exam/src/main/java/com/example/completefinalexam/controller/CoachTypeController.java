package com.example.completefinalexam.controller;

import com.example.completefinalexam.model.CoachType;
import com.example.completefinalexam.service.ICoachTypeService;
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
@RequestMapping("/api/coachType")
public class CoachTypeController {
    @Autowired
    private ICoachTypeService coachTypeService;

    @GetMapping("")
    public ResponseEntity<List<CoachType>> getAllCoachType() {
        List<CoachType> coachTypeList = this.coachTypeService.getAllCoachType();
        if (coachTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coachTypeList, HttpStatus.OK);
    }
}
