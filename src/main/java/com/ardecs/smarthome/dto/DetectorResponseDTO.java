package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.model.Location;
import com.ardecs.smarthome.model.User;

import java.time.Instant;

public class DetectorResponseDTO {
    private String id;
    private User ownerEmail;
    private Location location;
    private String description;
    private String name;
    private Instant registrationDate;
    private Instant lastActiveDate;
    private Boolean active;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(User ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Instant getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(Instant lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
