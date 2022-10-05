package com.ardecs.smarthome.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "detector")
public class Detector implements Serializable {
    @Id
    private String id;

    private LocalDateTime registration_date;
    private String ownerEmail;
    private String locationId;
    private String description;
    private String name;
    private LocalDateTime last_active_date;
    private boolean active;

    @PrePersist
    private void init() {
        id = String.valueOf(UUID.randomUUID());
        registration_date = LocalDateTime.now();
        last_active_date = LocalDateTime.now();
        active = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DetectorDAO{" +
                "registration_date=" + registration_date +
                ", id=" + id +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", locationId='" + locationId + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", last_active_date=" + last_active_date +
                ", active=" + active +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
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
}
