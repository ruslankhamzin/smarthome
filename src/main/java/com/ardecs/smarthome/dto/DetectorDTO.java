package com.ardecs.smarthome.dto;

import java.io.Serializable;

public class DetectorDTO implements Serializable {

    private String ownerEmail;

    private String locationId;

    private String description;

    private String name;

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
        return "DetectorDTO{" +
                "ownerEmail=" + ownerEmail +
                ", location=" + locationId +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
