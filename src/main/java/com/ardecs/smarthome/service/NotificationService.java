package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
import com.ardecs.smarthome.repository.NotificationRepository;
import com.ardecs.smarthome.strategy.NotificationStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class NotificationService {
    @Autowired
    private Map<String, NotificationStrategy> notificationStrategyMap;
    @Autowired
    private NotificationRepository notificationRepository;

    private static final ModelMapper MAPPER = new ModelMapper();

    public String send(NotificationDTO notificationDTO) {
       String code = notificationDTO.getType().name();
       NotificationStrategy notificationStrategy = notificationStrategyMap.get(code);
       notificationRepository.save(mapToNotification(notificationDTO));
       return notificationStrategy.send(notificationDTO);
    }

    private Notification mapToNotification(NotificationDTO notificationDTO) {
        Notification notification = MAPPER.map(notificationDTO, Notification.class);
        notification.setId(String.valueOf(UUID.randomUUID()));
        return notification;
    }
}
