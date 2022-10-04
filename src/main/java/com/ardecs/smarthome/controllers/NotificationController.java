package com.ardecs.smarthome.controllers;


import com.ardecs.smarthome.DTO.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping("/send")
    public NotificationDTO send(@RequestParam String detector_id,
                                @RequestParam String type,
                                @RequestParam LocalDateTime date) {
        NotificationDTO notificationDTO = new NotificationDTO(detector_id, type, date);
        LOGGER.info("notificationDTO " + notificationDTO + " has been sent");
        return notificationDTO;
    }

}
