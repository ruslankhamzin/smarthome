package com.ardecs.smarthome.repository;

import com.ardecs.smarthome.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
