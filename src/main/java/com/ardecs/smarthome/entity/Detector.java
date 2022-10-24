package com.ardecs.smarthome.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Detector implements Serializable {
    @Id
    private String id;
    private String description;
    private String name;
    private Instant lastActiveDate;
    private Boolean active;

    @CreatedDate
    private Instant registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_email")
    private User ownerEmail;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "detectorId",cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();

    @ManyToMany(mappedBy = "subscribers",cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Instant getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(Instant lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Detector{" +
                "id='" + id + '\'' +
                ", ownerEmail=" + ownerEmail +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", lastActiveDate=" + lastActiveDate +
                ", active=" + active +
                ", notifications=" + notifications +
                ", users=" + users +
                '}';
    }
}
