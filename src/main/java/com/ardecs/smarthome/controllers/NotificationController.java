package com.ardecs.smarthome.controllers;

import com.ardecs.smarthome.DAO.NotificationDAO;
import com.ardecs.smarthome.models.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);
    @Autowired
    private NotificationDAO notificationDAO;

    @PostMapping("/send")
    public Notification send(@RequestParam String detector_id,
                             @RequestParam String type,
                             @RequestParam LocalDateTime date) {
        Notification notification = new Notification(detector_id, type, date);
        notificationDAO.save(notification);
        LOGGER.info("notification " + notification + " has been sent");
        return notification;
    }

}
