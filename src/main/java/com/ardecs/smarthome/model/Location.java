package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class Location {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private Integer square;

    @OneToMany(mappedBy = "location")
    private Set<Detector> detectors = new LinkedHashSet<>();

    public Set<Detector> getDetectors() {
        return detectors;
    }

    public void setDetectors(Set<Detector> detectors) {
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
