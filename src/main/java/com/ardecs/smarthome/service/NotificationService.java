package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.model.Notification;
import com.ardecs.smarthome.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private DetectorService detectorService;
    @Autowired
    private JavaMailSender mailSender;

    public String send(NotificationDTO notificationDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(detectorService.findOwnerEmailById(notificationDTO.getDetector().getId()));
        mailMessage.setText("Датчик: " + notificationDTO.getType() + " сработал в: " + notificationDTO.getDate());
        mailSender.send(mailMessage);
        notificationRepository.save(notificationDTOToNotification(notificationDTO));
        return "notification has been sent";
    }

    public Notification notificationDTOToNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setId(String.valueOf(UUID.randomUUID()));
        notification.setDetectorId(notificationDTO.getDetector());
        notification.setType(notificationDTO.getType());
        return notification;
    }
}
