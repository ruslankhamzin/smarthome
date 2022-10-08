package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Subscriber implements Serializable {

    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "detector_id", nullable = false)
    private Detector detector;

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
