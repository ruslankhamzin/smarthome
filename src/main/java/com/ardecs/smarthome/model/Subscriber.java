package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Subscriber implements Serializable {

    @Id
    @Column
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "detector_id", nullable = false)
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
