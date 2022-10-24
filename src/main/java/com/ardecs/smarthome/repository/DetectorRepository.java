package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Detector;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.Instant;

@Repository
public interface DetectorRepository extends CrudRepository<Detector, String> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE detector SET last_active_date = ?2 WHERE id=?1 ",
            nativeQuery = true)
    void updateLastActiveDateForDetector(String id, Instant instant);
}
