package com.ardecs.smarthome.entity;

import com.ardecs.smarthome.strategy.NotificationType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Notification implements Serializable {
    @Id
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detector_id")
    private Detector detector;
    private NotificationType type;

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
