package com.ardecs.smarthome.models;

import java.io.Serializable;
import java.util.UUID;

public class Subscriber implements Serializable {
    private UUID id;
    private String detectorID;
    private String ownerEmail;

    public Subscriber(String detectorID, String ownerEmail) {
        id = UUID.randomUUID();
        this.detectorID = detectorID;
        this.ownerEmail = ownerEmail;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDetectorID() {
        return detectorID;
    }

    public void setDetectorID(String detectorID) {
        this.detectorID = detectorID;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @Override
    public String toString() {
        return "SubscriberDAO{" +
                "id=" + id +
                ", detectorID='" + detectorID + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }

}
