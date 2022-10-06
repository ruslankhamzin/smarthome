package com.ardecs.smarthome.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Notification implements Serializable {
    private UUID id;
    private String detectorId;
    private String type;
    private LocalDateTime date;

    public Notification(String detectorId, String type, LocalDateTime date) {
        id = UUID.randomUUID();
        this.detectorId = detectorId;
        this.type = type;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
                "id=" + id +
                ", detectorId='" + detectorId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
