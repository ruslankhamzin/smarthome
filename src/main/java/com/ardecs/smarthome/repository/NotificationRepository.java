package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, String> {

    @Query(value = "SELECT user_id FROM subscriber WHERE detector_id=?1;",
            nativeQuery = true)
    List<String> getUserIdByDetectorId(String id);
}
