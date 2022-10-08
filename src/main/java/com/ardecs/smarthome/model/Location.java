package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Location {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "square")
    private Integer square;

    @OneToMany(mappedBy = "location")
    private Set<Detector> detectors = new LinkedHashSet<>();

    public Set<Detector> getDetectors() {
        return detectors;
    }

    public void setDetectors(Set<Detector> detectors) {
        this.detectors = detectors;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
