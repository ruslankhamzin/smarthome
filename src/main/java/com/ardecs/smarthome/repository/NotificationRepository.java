package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, String> {

}
