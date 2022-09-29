package com.ardecs.smarthome.controllers;

import com.ardecs.smarthome.DAO.SubscriberDAO;
import com.ardecs.smarthome.models.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subscriber")
public class SubscriberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberController.class);
    @Autowired
    private SubscriberDAO subscriberDAO;

    @PostMapping("/subscribe")
    public Subscriber subscribe(@RequestParam String detectorId,
                                @RequestParam String ownerEmail) {
        Subscriber subscriber = new Subscriber(detectorId, ownerEmail);
        subscriberDAO.save(subscriber);
        LOGGER.info("subscribe request sent:" + subscriber);
        return subscriber;
    }
}
