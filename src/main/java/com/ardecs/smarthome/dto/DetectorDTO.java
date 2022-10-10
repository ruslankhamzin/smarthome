package com.ardecs.smarthome.dto;


import com.ardecs.smarthome.model.Location;
import com.ardecs.smarthome.model.User;

import java.io.Serializable;

public class DetectorDTO implements Serializable {
    private User ownerEmail;
    private Location locationId;
    private String description;
    private String name;

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
}
