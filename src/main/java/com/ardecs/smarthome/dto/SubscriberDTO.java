package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.entity.User;

import java.io.Serializable;

public class SubscriberDTO implements Serializable {

    private Detector detectorID;

    private User ownerEmail;

    public Detector getDetectorID() {
        return detectorID;
    }

    public void setDetectorID(Detector detectorID) {
        this.detectorID = detectorID;
    }

    public User getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(User ownerEmail) {
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
