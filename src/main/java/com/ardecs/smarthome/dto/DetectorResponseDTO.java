package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.entity.Location;
import com.ardecs.smarthome.entity.User;

import java.time.Instant;

public class DetectorResponseDTO {

    private String id;

    private User owner;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    @Override
    public String toString() {
        return "DetectorResponseDTO{"
                + "id='" + id + '\''
                + ", owner=" + owner
                + ", location=" + location
                + ", description='" + description + '\''
                + ", name='" + name + '\''
                + ", registrationDate=" + registrationDate
                + ", lastActiveDate=" + lastActiveDate
                + ", active=" + active
                + ", message='" + message + '\''
                + '}';
    }
}
