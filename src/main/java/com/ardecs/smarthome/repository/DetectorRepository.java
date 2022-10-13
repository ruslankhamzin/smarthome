package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Detector;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface DetectorRepository extends CrudRepository<Detector, String> {

    @Modifying
    @Query(value = "UPDATE detector SET last_active_date = ?2 WHERE id=?1 ",
    nativeQuery = true)
    Optional<Detector> updateLastActiveDateForDetector(String id, Instant instant);
}
