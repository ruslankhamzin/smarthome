package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.enums.NotificationType;

import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {

    private Detector detectorId;

    private NotificationType type;

    private Instant date;

    public Detector getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(Detector detectorId) {
        this.detectorId = detectorId;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
