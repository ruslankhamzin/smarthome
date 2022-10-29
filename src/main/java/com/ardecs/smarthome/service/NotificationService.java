package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
import com.ardecs.smarthome.repository.DetectorRepository;
import com.ardecs.smarthome.repository.NotificationRepository;
import com.ardecs.smarthome.repository.UserRepository;
import com.ardecs.smarthome.strategy.NotificationStrategy;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class NotificationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    private static final ModelMapper MAPPER = new ModelMapper();
    @Autowired
    private Map<String, NotificationStrategy> notificationStrategyMap;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private DetectorRepository detectorRepository;
    @Autowired
    private UserRepository userRepository;

    public String send(NotificationDTO notificationDTO) {
       String notificationType  = notificationDTO.getType().name();
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
