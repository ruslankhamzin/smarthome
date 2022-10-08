package com.ardecs.smarthome.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class User implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "registration_date", nullable = false)
    private Instant registrationDate;

    @Column(name = "last_login_date")
    private Instant lastLoginDate;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @OneToMany(mappedBy = "ownerEmail")
    private Set<Detector> ownerEmail = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "subscriber",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "detector_id"))
    private Set<Detector> subscribers = new LinkedHashSet<>();

    public Set<Detector> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Detector> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<Detector> getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(Set<Detector> ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Instant lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
