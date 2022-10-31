package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {
    private static final String COMPANY_EMAIL = "hamz1n.ruslan@yandex.ru";
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendActivationMessage(NotificationDTO notificationDTO, List<User> subscribers) {
        for (User user : subscribers) {
            mailSender.send(createActivationEmailMessage(notificationDTO, user.getEmail()));
        }
        return "Email notification about activation has been sent";
    }

    private SimpleMailMessage createActivationEmailMessage(NotificationDTO notificationDTO, String subscriberEmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(COMPANY_EMAIL);
        mailMessage.setTo(subscriberEmail);
        mailMessage.setText("Detector: " + notificationDTO.getType() + " сработал в: " + notificationDTO.getDate());

        return mailMessage;
    }

    public String sendSubscribeRequest(SubscriberDTO subscriberDTO) {
        mailSender.send(createSubscribeEmailMessage(subscriberDTO, subscriberDTO.getOwner().getEmail()));
        return "Email notification about subscribe request has been sent";
    }

    private SimpleMailMessage createSubscribeEmailMessage(SubscriberDTO subscriberDTO, String subscriberEmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(COMPANY_EMAIL);
        mailMessage.setTo(subscriberEmail);
        mailMessage.setText("Subscribe request from user with id: " + subscriberDTO.getOwner().getId() + "to detector with id: " + subscriberDTO.getDetector().getId());

        return mailMessage;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
