package com.ardecs.smarthome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class User implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private Instant registrationDate;

    @Column
    private Instant lastLoginDate;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "ownerEmail")
    private Set<Detector> ownerEmail = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "subscriber",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "detector_id"))
    private Set<Detector> subscribers = new LinkedHashSet<>();

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

    public Set<Detector> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Detector> subscribers) {
        this.subscribers = subscribers;
    }
}
