package com.ardecs.smarthome.service;

import com.ardecs.smarthome.entity.User;
import com.ardecs.smarthome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getSubscribers(List<String> usersId) {
        return (List<User>) userRepository.findAllById(usersId);
    }
}
