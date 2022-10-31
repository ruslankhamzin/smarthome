package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Detector;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;

public interface DetectorRepository extends CrudRepository<Detector, String> {
    @Modifying
    @Query("UPDATE Detector d SET d.lastActiveDate = ?2 WHERE d.id=?1")
    void updateLastActiveDateForDetector(String id, Instant instant);
}
