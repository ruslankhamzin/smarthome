package com.ardecs.smarthome.controllers;

import com.ardecs.smarthome.DAO.DetectorDAO;
import com.ardecs.smarthome.models.Detector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/detector")
public class DetectorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetectorController.class);
    @Autowired
    private DetectorDAO detectorDAO;

    @PostMapping("/create")
    public Detector create(@RequestParam String ownerEmail,
                           @RequestParam String locationId,
                           @RequestParam String description,
                           @RequestParam String name) {
        Detector detector = new Detector(ownerEmail, locationId, description, name);
        detectorDAO.save(detector);
        LOGGER.info("detector was created and save:" + detector);
        return detector;
    }
}
