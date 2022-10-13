package com.ardecs.smarthome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
