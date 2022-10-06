package com.ardecs.smarthome.controller;

import com.ardecs.smarthome.dto.SubscriberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subscriber")
public class SubscriberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberController.class);

    @PostMapping("/subscribe")
    public SubscriberDTO subscribe(@RequestBody SubscriberDTO subscriberDTO) {
        SubscriberDTO subscriber = subscriberDTO;
        LOGGER.info("subscribe request sent:" + subscriberDTO);
        return subscriberDTO;
    }
}
