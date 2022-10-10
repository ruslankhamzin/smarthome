package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.model.Detector;

import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {
    private Detector detector;
    private String type;
    private Instant date;

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
