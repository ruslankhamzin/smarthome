package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, String> {
}
