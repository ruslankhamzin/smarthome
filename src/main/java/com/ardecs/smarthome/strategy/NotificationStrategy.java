package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.User;

import java.util.List;

public interface NotificationStrategy {
    String sendActivationMessage(NotificationDTO notificationDTO, List<User> subscribers);
    NotificationType getType();
}
