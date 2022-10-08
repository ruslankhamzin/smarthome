package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.model.Location;
import com.ardecs.smarthome.model.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.time.LocalDateTime;

public class DetectorResponseDTO {
    private String id;
    private User ownerEmail;
    private Location location;
    private String description;
    private String name;
    private Instant registrationDate;
    private Instant lastActiveDate;
    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
        this.registration_date = registration_date;
    }

    public User getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(User ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
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

    public LocalDateTime getLast_active_date() {
        return last_active_date;
    }

    public void setLast_active_date(LocalDateTime last_active_date) {
        this.last_active_date = last_active_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Location locationId;
    private String description;
    private String name;
    private LocalDateTime last_active_date;
    private boolean active;
    private String message;


}
