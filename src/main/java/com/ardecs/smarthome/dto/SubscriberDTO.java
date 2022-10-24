package com.ardecs.smarthome.dto;

import java.io.Serializable;

public class SubscriberDTO implements Serializable {
    private String detectorID;

    private String ownerEmail;

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
                "detectorID='" + detectorID + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }

}
