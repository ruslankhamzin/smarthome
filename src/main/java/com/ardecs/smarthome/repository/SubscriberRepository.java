package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.Subscriber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, String> {
    @Query(value = "SELECT `user`.`email`\n" +
            "FROM `smarthome`.`user` \n" +
            "INNER JOIN `smarthome`.`subscriber` ON\t`user`.`id` = `subscriber`.`user_id` WHERE `subscriber`.`detector_id`=?1;",
            nativeQuery = true)
    List<String> getSubscribersEmail(String id);
}
