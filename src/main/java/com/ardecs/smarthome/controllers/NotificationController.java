package com.ardecs.smarthome.controllers;


import com.ardecs.smarthome.DTO.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping("/send")
    public NotificationDTO send(@RequestBody NotificationDTO notificationDTO) {
        NotificationDTO notification = notificationDTO;
        LOGGER.info("notificationDTO " + notificationDTO + " has been sent");
        return notificationDTO;
    }

}
