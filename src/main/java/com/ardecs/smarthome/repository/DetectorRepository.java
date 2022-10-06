package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.model.Detector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectorRepository extends CrudRepository<Detector, Long> {
}
