package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, String> {

}
