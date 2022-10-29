package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
import com.ardecs.smarthome.repository.DetectorRepository;
import com.ardecs.smarthome.repository.NotificationRepository;
import com.ardecs.smarthome.repository.UserRepository;
import com.ardecs.smarthome.strategy.NotificationStrategy;
import com.ardecs.smarthome.strategy.NotificationType;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class NotificationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    private static final ModelMapper MAPPER = new ModelMapper();
    private Map<NotificationType, NotificationStrategy> notificationStrategyMap;
    private NotificationRepository notificationRepository;
    private UserRepository userRepository;

    @Autowired
    public NotificationService(Set<NotificationStrategy> notificationStrategyList, NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
        notificationStrategyMap = new HashMap<>();
        notificationStrategyList.stream().forEach(notificationStrategy -> notificationStrategyMap.put(notificationStrategy.getType(),notificationStrategy));
    }


    public String send(NotificationDTO notificationDTO) {
       NotificationType notificationType  = notificationDTO.getType();
       NotificationStrategy notificationStrategy = notificationStrategyMap.get(notificationType);
       Notification notification = notificationRepository.save(mapToNotification(notificationDTO));
       LOGGER.info("Notification with data: " + notification + " has been saved.");
       return notificationStrategy.sendActivationMessage(notificationDTO, userRepository.getSubscribers(notificationDTO.getDetector().getId()));
    }

    private Notification mapToNotification(NotificationDTO notificationDTO) {
        Notification notification = MAPPER.map(notificationDTO, Notification.class);
        notification.setId(String.valueOf(UUID.randomUUID()));
        return notification;
    }
}
