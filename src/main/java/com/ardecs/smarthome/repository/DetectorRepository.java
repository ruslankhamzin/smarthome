package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Detector;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.time.Instant;

public interface DetectorRepository extends CrudRepository<Detector, String> {
    @Transactional
    @Modifying
    @Query("UPDATE Detector SET last_active_date = ?2 WHERE id=?1")
    void updateLastActiveDateForDetector(String id, Instant instant);
}
