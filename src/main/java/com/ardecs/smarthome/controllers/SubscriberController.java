package com.ardecs.smarthome.controllers;

import com.ardecs.smarthome.DTO.SubscriberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subscriber")
public class SubscriberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberController.class);

    @PostMapping("/subscribe")
    public SubscriberDTO subscribe(@RequestParam String detectorId,
                                   @RequestParam String ownerEmail) {
        SubscriberDTO subscriberDTO = new SubscriberDTO(detectorId, ownerEmail);
        LOGGER.info("subscribe request sent:" + subscriberDTO);
        return subscriberDTO;
    }
}
