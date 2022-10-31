package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
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
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Set<NotificationStrategy> notificationStrategySet;

    public String send(NotificationDTO notificationDTO) {
        NotificationStrategy notificationStrategy = getNotificationStrategy(notificationDTO);
        Notification notification = notificationRepository.save(mapToNotification(notificationDTO));

        LOGGER.info("Notification with data: " + notification + " has been saved.");
        return notificationStrategy.sendActivationMessage(notificationDTO, userRepository.getSubscribers(notificationDTO.getDetector().getId()));
    }

    private NotificationStrategy getNotificationStrategy(NotificationDTO notificationDTO) {
        createNotificationStrategyMap(notificationStrategySet);
        return notificationStrategyMap.get(notificationDTO.getType());
    }

    private void createNotificationStrategyMap(Set<NotificationStrategy> notificationStrategySet) {
        notificationStrategyMap = new HashMap<>();
        notificationStrategySet.stream()
                .forEach(notificationStrategy -> notificationStrategyMap.put(notificationStrategy.getType(), notificationStrategy));
    }

    private Notification mapToNotification(NotificationDTO notificationDTO) {
        Notification notification = MAPPER.map(notificationDTO, Notification.class);
        notification.setId(String.valueOf(UUID.randomUUID()));
        return notification;
    }
}
