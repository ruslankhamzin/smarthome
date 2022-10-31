package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.entity.Location;
import com.ardecs.smarthome.entity.User;

import java.io.Serializable;

public class DetectorDTO implements Serializable {
    private User owner;
    private Location location;
    private String description;
    private String name;

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

    @Override
    public String toString() {
        return "DetectorDTO{"
                + "ownerEmail=" + owner
                + ", location=" + location
                + ", description='" + description + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
