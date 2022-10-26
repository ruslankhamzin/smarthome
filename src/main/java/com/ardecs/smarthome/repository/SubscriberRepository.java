package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Subscriber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<Subscriber, String> {
    @Query(value = "SELECT email FROM user INNER JOIN subscriber ON user.id = user_id WHERE detector_id = ?1",
            nativeQuery = true)
    List<String> getSubscribersEmail(String id);
}
