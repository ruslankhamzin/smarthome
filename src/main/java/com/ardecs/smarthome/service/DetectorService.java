package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.model.Detector;
import com.ardecs.smarthome.repository.DetectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetectorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetectorService.class);
    @Autowired
    private DetectorRepository detectorRepository;

    public Detector create(DetectorDTO detectorDTO) {
        Detector detector = new Detector();
        detector.setName(detectorDTO.getName());
        detector.setDescription(detectorDTO.getDescription());
        detector.setLocationId(detectorDTO.getLocationId());
        detector.setOwnerEmail(detectorDTO.getOwnerEmail());
        detectorRepository.save(detector);
        return detector;
    }
}