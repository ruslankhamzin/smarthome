package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public class EmailNotificationStrategy implements NotificationStrategy {
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String send(NotificationDTO notificationDTO) {
        List<String> usersEmails = getSubscribers(notificationDTO.getDetectorId());
        for (String userEmail : usersEmails) {
            mailSender.send(createEmailMessage(notificationDTO, userEmail));
        }
        return "notification has been sent";
    }

    private SimpleMailMessage createEmailMessage(NotificationDTO notificationDTO, String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setText("Detector: " + notificationDTO.getType() + " сработал в: " + notificationDTO.getDate());
        return mailMessage;
    }

    private List<String> getSubscribers(String detectorId) {
        return subscriberRepository.getSubscribersEmail(detectorId);
    }
}
