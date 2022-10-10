package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.dto.DetectorResponseDTO;
import com.ardecs.smarthome.model.Detector;
import com.ardecs.smarthome.repository.DetectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class DetectorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetectorService.class);
    @Autowired
    private DetectorRepository detectorRepository;

    public DetectorResponseDTO create(DetectorDTO detectorDTO) {
        Detector detector = new Detector();
        detector.setId(String.valueOf(UUID.randomUUID()));
        detector.setLastActiveDate(Instant.now());
        detector.setName(detectorDTO.getName());
        detector.setDescription(detectorDTO.getDescription());
        detector.setLocationId(detectorDTO.getLocationId());
        detector.setOwnerEmail(detectorDTO.getOwnerEmail());
        detector.setActive(true);
        detector.setRegistrationDate(Instant.now());
        detectorRepository.save(detector);
        return detectorToDetectorResponseDTO(detector);
    }

    public DetectorResponseDTO detectorToDetectorResponseDTO(Detector detector) {
        DetectorResponseDTO detectorResponseDTO = new DetectorResponseDTO();
        detectorResponseDTO.setId(detector.getId());
        detectorResponseDTO.setActive(detector.getActive());
        detectorResponseDTO.setDescription(detector.getDescription());
        detectorResponseDTO.setName(detector.getName());
        detectorResponseDTO.setLocation(detector.getLocationId());
        detectorResponseDTO.setOwnerEmail(detector.getOwnerEmail());
        detectorResponseDTO.setLastActiveDate(detector.getLastActiveDate());
        detectorResponseDTO.setMessage("Detector successfully added");
        return detectorResponseDTO;
    }

    public String findOwnerEmailById(String detectorId) {
        String ownerEmail = detectorRepository.findById(detectorId).orElseThrow(() -> new IllegalArgumentException("Такого датчика не существует"));
        return ownerEmail;
    }
}
