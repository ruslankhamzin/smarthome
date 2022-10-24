package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;

public class WebNotificationStrategy implements NotificationStrategy {
    @Override
    public String send(NotificationDTO notificationDTO) {
        sendMessage(notificationDTO);
        return null;
    }

    private String sendMessage(NotificationDTO notificationDTO) {
        return "notification has been sent";
    }

    private void createMessage(NotificationDTO notificationDTO) {
    }
}
