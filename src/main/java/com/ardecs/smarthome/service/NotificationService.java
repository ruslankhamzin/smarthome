package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
import com.ardecs.smarthome.repository.NotificationRepository;
import com.ardecs.smarthome.strategy.EmailNotificationStrategy;
import com.ardecs.smarthome.strategy.NotificationStrategy;
import com.ardecs.smarthome.strategy.WebNotificationStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private NotificationStrategy notificationStrategy;
    private static final ModelMapper MAPPER = new ModelMapper();
    @Autowired
    private NotificationRepository notificationRepository;

    public String send(NotificationDTO notificationDTO) {
        switch (notificationDTO.getType().name()){
            case "EMAIL":
                notificationStrategy = new EmailNotificationStrategy();
                break;
            case "WEB":
                notificationStrategy = new WebNotificationStrategy();
                break;
        }
        notificationRepository.save(mappedToNotification(notificationDTO));
        return notificationStrategy.send(notificationDTO);
    }

    private Notification mappedToNotification(NotificationDTO notificationDTO) {
        return MAPPER.map(notificationDTO, Notification.class);
    }
}
