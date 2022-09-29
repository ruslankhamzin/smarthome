package com.ardecs.smarthome.DAO;

import com.ardecs.smarthome.models.Notification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class NotificationDAO implements DAO<Notification> {
    @Override
    public Optional<Notification> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Notification> getAll() {
        return null;
    }

    @Override
    public void save(Notification notification) {

    }

    @Override
    public void update(Notification notification, String[] params) {

    }

    @Override
    public void delete(Notification notification) {

    }
}
