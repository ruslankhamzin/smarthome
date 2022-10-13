package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Notification;
import com.ardecs.smarthome.entity.User;
import com.ardecs.smarthome.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private static final ModelMapper MAPPER = new ModelMapper();

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    public String send(NotificationDTO notificationDTO) {
        switch (notificationDTO.getType().name()) {
            case "EMAIL":
               return sendEmailNotification(notificationDTO);
            case "WEB":
                //  sendWebNotification();
        }
        notificationRepository.save(mappedToNotification(notificationDTO));
        return "";
    }

    private String sendEmailNotification(NotificationDTO notificationDTO) {
        List<User> usersId =getSubscribers(notificationDTO.getDetectorId().getId());
        for (User user : usersId) {
            mailSender.send(createEmailMessage(notificationDTO, user.getEmail()));
        }
        return "notification has been sent";
    }

    private SimpleMailMessage createEmailMessage(NotificationDTO notificationDTO,String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setText("Detector: " + notificationDTO.getType() + " сработал в: " + notificationDTO.getDate());
        return mailMessage;
    }

    private List<User> getSubscribers(String detectorId) {
        List<String> usersId = notificationRepository.getUserIdByDetectorId(detectorId);
        return userService.getSubscribers(usersId);
    }

    private Notification mappedToNotification(NotificationDTO notificationDTO) {
        return MAPPER.map(notificationDTO, Notification.class);
    }
}
