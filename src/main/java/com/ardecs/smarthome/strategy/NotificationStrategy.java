package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;

public interface NotificationStrategy {
    String send(NotificationDTO notificationDTO);
}
