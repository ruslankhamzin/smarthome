package com.ardecs.smarthome.strategy;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.entity.User;
import com.ardecs.smarthome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EMAIL")
public class EmailNotificationStrategy implements NotificationStrategy {
    @Autowired
    private UserRepository subscriberRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendActivationMessage(NotificationDTO notificationDTO, List<User> users) {
        for (User user : users) {
            mailSender.send(createActivationEmailMessage(notificationDTO, user.getEmail()));
        }
        return "Email notification about activation has been sent";
    }

    private SimpleMailMessage createActivationEmailMessage(NotificationDTO notificationDTO, String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setText("Detector: " + notificationDTO.getType() + " сработал в: " + notificationDTO.getDate());
        return mailMessage;
    }

    public String sendSubscribeRequest(SubscriberDTO subscriberDTO) {
        mailSender.send(createSubscribeEmailMessage(subscriberDTO, subscriberDTO.getOwner().getEmail()));
        return "Email notification about subscribe request has been sent";
    }

    private SimpleMailMessage createSubscribeEmailMessage(SubscriberDTO subscriberDTO, String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setText("Subscribe request from user with id: " + subscriberDTO.getOwner().getId() + "to detector with id: " + subscriberDTO.getDetector().getId());
        return mailMessage;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
