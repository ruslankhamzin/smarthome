package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.strategy.EmailNotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private EmailNotificationStrategy emailNotificationStrategy;

    public String subscribe(SubscriberDTO subscriberDTO) {
        return emailNotificationStrategy.sendSubscribeRequest(subscriberDTO);
    }
}
