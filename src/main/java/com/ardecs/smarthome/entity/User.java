package com.ardecs.smarthome.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User implements Serializable {
    @Id
    private String id;
    private String email;
    private String password;
    private String fullname;
    @CreatedDate
    private Instant registrationDate;
    private Instant lastLoginDate;
    private String phoneNumber;
    @OneToMany(mappedBy = "ownerEmail", cascade = CascadeType.ALL)
    private Set<Detector> ownerEmail = new LinkedHashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriber",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "detector_id"))
    private List<Detector> subscribers = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Instant getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Instant lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Detector> getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(Set<Detector> ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public List<Detector> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Detector> subscribers) {
        this.subscribers = subscribers;
    }
}
