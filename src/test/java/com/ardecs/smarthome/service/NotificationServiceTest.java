package com.ardecs.smarthome.service;

import com.ardecs.smarthome.entity.User;
import com.ardecs.smarthome.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

class NotificationServiceTest {
    @Autowired
    UserRepository userRepository;
    @Test
    void send() {
        User user = userRepository.findById("12").get();
    }
}