package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.enums.NotificationType;

import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {

    private String detectorId;

    private NotificationType type;

    private Instant date;

    public String getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(String detectorId) {
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

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "detectorId='" + detectorId + '\'' +
                ", type=" + type +
                ", date=" + date +
                '}';
    }
}
