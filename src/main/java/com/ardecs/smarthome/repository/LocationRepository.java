package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {
}
