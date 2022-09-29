package com.ardecs.smarthome.DAO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DAO<T> {
    Optional<T> get(UUID id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
