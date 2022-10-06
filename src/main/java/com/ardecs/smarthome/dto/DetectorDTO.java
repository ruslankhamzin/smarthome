package com.ardecs.smarthome.dto;

import java.io.Serializable;

public class DetectorDTO implements Serializable {
    private String ownerEmail;
    private String locationId;
    private String description;
    private String name;

    public DetectorDTO(String ownerEmail, String locationId, String description, String name) {
        this.ownerEmail = ownerEmail;
        this.locationId = locationId;
        this.description = description;
        this.name = name;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Detector{" +
                "ownerEmail='" + ownerEmail + '\'' +
                ", locationId='" + locationId + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
