package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Subscriber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<Subscriber, String> {
    @Query("SELECT u.email FROM User u, Subscriber s  WHERE u.id=s.owner and detector_id = ?1")
    List<String> getSubscribersEmail(String id);
}
