package com.ardecs.smarthome.controller;

import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.model.User;
import com.ardecs.smarthome.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subscriber")
public class SubscriberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberController.class);
    @Autowired
    private SubscriberService subscriberService;
    @PostMapping("/subscribe")
    public String subscribe(@RequestBody SubscriberDTO subscriberDTO) {
        return subscriberService.subscribe(subscriberDTO);
    }
}
