package com.ardecs.smarthome.controller;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.dto.DetectorResponseDTO;
import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.service.DetectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/detector")
public class DetectorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetectorController.class);

    @Autowired
    private DetectorService detectorService;

    @PostMapping("/create")
    public DetectorResponseDTO create(@RequestBody DetectorDTO detector) {
        LOGGER.info("Request to save the detector with parameters: " + detector.toString());
        return detectorService.create(detector);
    }

    @PostMapping("/triggering")
    public String triggering(@RequestBody NotificationDTO notificationDTO) {
        return detectorService.triggering(notificationDTO);
    }
}
