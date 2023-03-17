package com.example.completefinalexam.controller;

import com.example.completefinalexam.model.Coach;
import com.example.completefinalexam.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    //get list
    @GetMapping("")
    public ResponseEntity<Page<Coach>> pagingAndGetAllCoach() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Coach> coachPage = this.coachService.getAll(pageable);
        if (coachPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coachPage, HttpStatus.OK);
    }
}
