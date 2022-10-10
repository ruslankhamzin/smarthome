package com.ardecs.smarthome.controller;


import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String send(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.send(notificationDTO);
    }

}
