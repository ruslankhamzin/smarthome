package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.model.Subscriber;
import com.ardecs.smarthome.model.User;
import com.ardecs.smarthome.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;

    public String subscribe(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(String.valueOf(UUID.randomUUID()));
        subscriber.setDetectorId(subscriberDTO.getDetectorID());
        subscriber.setUserId(subscriberDTO.getOwnerEmail());
        subscriberRepository.save(subscriber);
        return "request has been sent";
    }
}
