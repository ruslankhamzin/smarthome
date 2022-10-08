package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class Notification implements Serializable {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "detector_id", nullable = false)
    private Detector detector;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
}
