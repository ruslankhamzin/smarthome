package com.ardecs.smarthome.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationDTO implements Serializable {
    private String detectorId;
    private String type;
    private LocalDateTime date;
    public String getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(String detectorId) {
        this.detectorId = detectorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NotificationDAO{" +
                "detectorId='" + detectorId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
