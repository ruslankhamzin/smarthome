package com.ardecs.smarthome.dto;

import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.strategy.NotificationType;

import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {
    private Detector detector;
    private NotificationType type;
    private Instant date;

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
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
        return "NotificationDTO{"
                + "detectorId='" + detector + '\''
                + ", type=" + type
                + ", date=" + date
                + '}';
    }
}
