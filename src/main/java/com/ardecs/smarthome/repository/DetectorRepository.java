package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.models.Detector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectorRepository extends JpaRepository<Detector, Long> {
}
