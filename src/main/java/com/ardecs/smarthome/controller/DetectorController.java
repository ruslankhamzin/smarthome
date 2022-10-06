package com.ardecs.smarthome.controller;

import com.ardecs.smarthome.dto.DetectorDTO;
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
    public DetectorDTO create(@RequestBody DetectorDTO detector) {
        detectorService.create(detector);
        LOGGER.info("detectorDTO was created and save:" + detector);
        return detector;
    }
}
