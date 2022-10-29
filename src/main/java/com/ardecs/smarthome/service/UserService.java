package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.strategy.EmailNotificationStrategy;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private static final ModelMapper MAPPER = new ModelMapper();

    @Autowired
    EmailNotificationStrategy emailNotificationStrategy;

    public String subscribe(SubscriberDTO subscriberDTO) {
        return emailNotificationStrategy.sendSubscribeRequest(subscriberDTO);
    }
}
