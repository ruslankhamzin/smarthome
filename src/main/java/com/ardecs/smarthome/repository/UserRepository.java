package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT u FROM User u, Detector d  WHERE u.id=d.owner and d.id = ?1")
    List<User> getSubscribers(String id);
}
