package com.example.completefinalexam.model;

import javax.persistence.*;

@Entity
public class Coach {
    @Id
    private int numberPlate;
    private int phoneNumber;
    private String departureTime;
    private String arrivalTime;
    private boolean deleted;
    @ManyToOne
    @JoinColumn(name = "coach_type_id", referencedColumnName = "id")
    private CoachType coachType;

    @ManyToOne
    @JoinColumn(name = "departure_id", referencedColumnName = "id")
    private Departure departure;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Destination destination;

    public Coach() {
    }

    public Coach(int numberPlate, int phoneNumber, String departureTime, String arrivalTime, boolean deleted, CoachType coachType, Departure departure, Destination destination) {
        this.numberPlate = numberPlate;
        this.phoneNumber = phoneNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.deleted = deleted;
        this.coachType = coachType;
        this.departure = departure;
        this.destination = destination;
    }

    public int getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(int numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public void setCoachType(CoachType coachType) {
        this.coachType = coachType;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
