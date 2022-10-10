package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Notification implements Serializable {
    @Id
    @Column
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "detector_id", nullable = false)
    private Detector detectorId;

    @Column
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Detector getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(Detector detectorId) {
        this.detectorId = detectorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
