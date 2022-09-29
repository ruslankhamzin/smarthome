package com.ardecs.smarthome.DAO;

import com.ardecs.smarthome.models.Detector;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DetectorDAO implements DAO<Detector> {
    @Override
    public Optional<Detector> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Detector> getAll() {
        return null;
    }

    @Override
    public void save(Detector detector) {

    }

    @Override
    public void update(Detector detector, String[] params) {

    }

    @Override
    public void delete(Detector detector) {

    }
}
