package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.dto.DetectorResponseDTO;
import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.entity.Location;
import com.ardecs.smarthome.entity.User;
import com.ardecs.smarthome.repository.DetectorRepository;
import com.ardecs.smarthome.strategy.NotificationType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NotificationServiceTest {
    @Autowired
    NotificationService notificationService;
    @Autowired
    DetectorService detectorService;
    @Autowired
    DetectorRepository detectorRepository;
    @Test
    void send() {
        User user = new User();
        user.setId("80145217-81ab-4092-9984-a1fd5094dddf");
        user.setEmail("ruslan1111@mail.ru");
        user.setFullname("RUSLAN1");
        user.setPhoneNumber("89634561");
        user.setPassword("qwerty1");
        user.setRegistrationDate(Instant.now());
        user.setLastLoginDate(Instant.now());
        Location location = new Location();
        location.setId("d8f008a3-8864-4283-a202-d8464daab345");
        location.setSquare(33);
        location.setName("kitchen");
        DetectorDTO detectorDTO = new DetectorDTO();
        detectorDTO.setOwner(user);
        detectorDTO.setName("My first detector");
        detectorDTO.setLocation(location);
        DetectorResponseDTO detectorResponseDTO=detectorService.create(detectorDTO);
        Detector detector = detectorRepository.findById(detectorResponseDTO.getId()).get();
       NotificationDTO notificationDTO = new NotificationDTO();
       notificationDTO.setDate(Instant.now());
       notificationDTO.setDetector(detector);
       notificationDTO.setType(NotificationType.WEB);
       String response = notificationService.send(notificationDTO);
        assertEquals("Detector: " + notificationDTO.getDetector().getId() + " was activated in: " + notificationDTO.getDate(),response);
        notificationDTO.setType(NotificationType.EMAIL);
        response = notificationService.send(notificationDTO);
        assertEquals("email notification has been sent", response);
    }
}