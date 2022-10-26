package com.ardecs.smarthome.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    @Id
    private String id;
    private String name;
    private Integer square;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Detector> detectors = new ArrayList<>();

    public List<Detector> getDetectors() {
        return detectors;
    }

    public void setDetectors(List<Detector> detectors) {
        this.detectors = detectors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }
}
