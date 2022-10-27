package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
import com.ardecs.smarthome.repository.DetectorRepository;
import com.ardecs.smarthome.repository.NotificationRepository;
import com.ardecs.smarthome.strategy.NotificationStrategy;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Service
public class NotificationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    @Autowired
    private Map<String, NotificationStrategy> notificationStrategyMap;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private DetectorRepository detectorRepository;

    private static final ModelMapper MAPPER = new ModelMapper();

    public String send(NotificationDTO notificationDTO) {
       String code = notificationDTO.getType().name();
       NotificationStrategy notificationStrategy = notificationStrategyMap.get(code);
       Notification notification =notificationRepository.save(mapToNotification(notificationDTO));
       LOGGER.info("Notification with data: "+ notification + "has been saved.");
       detectorRepository.updateLastActiveDateForDetector(notificationDTO.getDetector().getId(), Instant.now());
       return notificationStrategy.send(notificationDTO);
    }

    private Notification mapToNotification(NotificationDTO notificationDTO) {
        Notification notification = MAPPER.map(notificationDTO, Notification.class);
        notification.setId(String.valueOf(UUID.randomUUID()));
        return notification;
    }
}
