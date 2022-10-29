package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.entity.User;

import java.io.Serializable;

public class SubscriberDTO implements Serializable {

    private Detector detector;

    private User owner;

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "SubscriberDTO{"
                + "detector=" + detector
                + ", owner=" + owner
                + '}';
    }
}
