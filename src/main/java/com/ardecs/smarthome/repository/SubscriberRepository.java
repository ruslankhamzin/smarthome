package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.model.Detector;
import com.ardecs.smarthome.model.Subscriber;
import com.ardecs.smarthome.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber,Long> {
}
