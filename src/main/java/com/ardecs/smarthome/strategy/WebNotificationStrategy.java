package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/*
Этот класс не был реализован в полной мере
 */

@Component("WEB")
public class WebNotificationStrategy implements NotificationStrategy {

    @Override
    public String sendActivationMessage(NotificationDTO notificationDTO, List<User> subscribers) {
        return createMessage(notificationDTO);
    }

    private String createMessage(NotificationDTO notificationDTO) {
        return "Detector: " + notificationDTO.getDetector().getId() + " сработал в: " + notificationDTO.getDate();
    }

    @Override
    public NotificationType getType() {
        return NotificationType.WEB;
    }
}
