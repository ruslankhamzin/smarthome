package com.ardecs.smarthome.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table
public class Detector implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_email")
    private User ownerEmail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date", nullable = false)
    private Instant registrationDate;

    @Column(name = "last_active_date")
    private Instant lastActiveDate;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "detector")
    private Set<Notification> notifications = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "subscribers")
    private Set<User> users = new LinkedHashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Instant getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(Instant lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(User ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
