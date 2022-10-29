package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.dto.DetectorResponseDTO;
import com.ardecs.smarthome.dto.SubscriberDTO;
import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.entity.Location;
import com.ardecs.smarthome.entity.User;
import com.ardecs.smarthome.repository.DetectorRepository;
import com.ardecs.smarthome.repository.LocationRepository;
import com.ardecs.smarthome.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    DetectorService detectorService;
    @Autowired
    DetectorRepository detectorRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LocationRepository locationRepository;
    @Test
    void subscribe() {
        User user = new User();
        user.setId("80145217-81ab-4092-9984-a1fd5094dddf");
        user.setEmail("ruslan1111@mail.ru");
        user.setFullname("RUSLAN1");
        user.setPhoneNumber("89634561");
        user.setPassword("qwerty1");
        user.setRegistrationDate(Instant.now());
        user.setLastLoginDate(Instant.now());
        userRepository.save(user);
        Location location = new Location();
        location.setId("d8f008a3-8864-4283-a202-d8464daab345");
        location.setSquare(33);
        location.setName("kitchen");
        locationRepository.save(location);
        DetectorDTO detectorDTO = new DetectorDTO();
        detectorDTO.setOwner(user);
        detectorDTO.setName("My first detector");
        detectorDTO.setLocation(location);
        DetectorResponseDTO detectorResponseDTO=detectorService.create(detectorDTO);
        Detector detector = detectorRepository.findById(detectorResponseDTO.getId()).get();
        SubscriberDTO subscriberDTO = new SubscriberDTO();
        subscriberDTO.setDetector(detector);
        subscriberDTO.setOwner(user);
        String response = userService.subscribe(subscriberDTO);
        assertEquals("email notification about subscribe request has been sent",response);
    }
}