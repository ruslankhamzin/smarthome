package com.ardecs.smarthome.DAO;

import com.ardecs.smarthome.models.Subscriber;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SubscriberDAO implements DAO<Subscriber> {
    @Override
    public Optional<Subscriber> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Subscriber> getAll() {
        return null;
    }

    @Override
    public void save(Subscriber subscriber) {

    }

    @Override
    public void update(Subscriber subscriber, String[] params) {

    }

    @Override
    public void delete(Subscriber subscriber) {

    }
}
