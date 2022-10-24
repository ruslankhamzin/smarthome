package com.ardecs.smarthome.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Subscriber implements Serializable {
    @Id
    private String id;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "detector_id")
    private Detector detectorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Detector getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(Detector detectorId) {
        this.detectorId = detectorId;
    }
}
