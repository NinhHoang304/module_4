package com.example.completefinalexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CoachType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "coachType")
    private Set<Coach> coachSet;

    public CoachType() {
    }

    public CoachType(int id, String name, Set<Coach> coachSet) {
        this.id = id;
        this.name = name;
        this.coachSet = coachSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Coach> getCoachSet() {
        return coachSet;
    }

    public void setCoachSet(Set<Coach> coachSet) {
        this.coachSet = coachSet;
    }
}
