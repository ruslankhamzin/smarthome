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
public class Notification implements Serializable {

    @Id
    @Column
    private String id;

    @ManyToOne
    @JoinColumn(name = "detector_id")
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
