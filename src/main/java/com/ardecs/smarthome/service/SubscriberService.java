package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.entity.Subscriber;
import com.ardecs.smarthome.repository.SubscriberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberService.class);
    private static final ModelMapper MAPPER = new ModelMapper();
    @Autowired
    private SubscriberRepository subscriberRepository;

    public String subscribe(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = mapToSubscriber(subscriberDTO);
        subscriberRepository.save(subscriber);
        LOGGER.info("Subscriber with data:" + subscriber + "has been saved.");
        return "request has been sent";
    }

    private Subscriber mapToSubscriber(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = MAPPER.map(subscriberDTO, Subscriber.class);
        subscriber.setId(String.valueOf(UUID.randomUUID()));
        subscriber.setStatus("waiting");
        return subscriber;
    }

}
