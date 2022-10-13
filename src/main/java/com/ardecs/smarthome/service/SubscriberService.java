package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.entity.Subscriber;
import com.ardecs.smarthome.repository.SubscriberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriberService {

    private static final ModelMapper MAPPER = new ModelMapper();

    @Autowired
    private SubscriberRepository subscriberRepository;

    public String subscribe(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = mappedToSubscriber(subscriberDTO);
        subscriberRepository.save(subscriber);
        return "request has been sent";
    }

    private Subscriber mappedToSubscriber(SubscriberDTO subscriberDTO){
        Subscriber subscriber = MAPPER.map(subscriberDTO, Subscriber.class);
        initSubscriber(subscriber);
        return subscriber;
    }

    private Subscriber initSubscriber(Subscriber subscriber) {
        subscriber.setId(String.valueOf(UUID.randomUUID()));
        return subscriber;
    }
}
