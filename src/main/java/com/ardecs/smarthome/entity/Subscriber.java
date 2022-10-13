package com.ardecs.smarthome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class Subscriber implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String status;

    @ManyToOne
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
