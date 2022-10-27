package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;
import org.springframework.stereotype.Component;

@Component("WEB")
public class WebNotificationStrategy implements NotificationStrategy {
    @Override
    public String send(NotificationDTO notificationDTO) {
       return sendMessage(notificationDTO);
    }

    private String sendMessage(NotificationDTO notificationDTO) {
        return "web notification has been sent";
    }

    private String createMessage(NotificationDTO notificationDTO) {
        return "Detector: " + notificationDTO.getType() + " сработал в: " + notificationDTO.getDate();
    }
}
