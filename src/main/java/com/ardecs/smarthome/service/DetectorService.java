package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.dto.DetectorResponseDTO;
import com.ardecs.smarthome.model.Detector;
import com.ardecs.smarthome.repository.DetectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DetectorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetectorService.class);
    @Autowired
    private DetectorRepository detectorRepository;

   /* public DetectorResponseDTO create(DetectorDTO detectorDTO) {
      /*  Detector detector = new Detector();
        detector.setId(String.valueOf(UUID.randomUUID()));
        detector.setLastActiveDate(LocalDateTime.now());
        detector.setName(detectorDTO.getName());
        detector.setDescription(detectorDTO.getDescription());
        detector.setLocation(detectorDTO.getLocationId());
        detector.setOwnerEmail(detectorDTO.getOwnerEmail());
        detector.setActive(true);
        detector.setLastActiveDate(LocalDateTime.now());
        detectorRepository.save(detector);
        return detectorToDetectorResponseDTO(detector);
    }
    public DetectorResponseDTO detectorToDetectorResponseDTO(Detector detector){
        DetectorResponseDTO detectorResponseDTO = new DetectorResponseDTO();
        detectorResponseDTO.setId(detector.getId());
        detectorResponseDTO.setActive(detector.isActive());
        detectorResponseDTO.setDescription(detector.getDescription());
        detectorResponseDTO.setName(detector.getName());
        detectorResponseDTO.setLocationId(detector.getLocation());
        detectorResponseDTO.setOwnerEmail(detector.getEmail());
        detectorResponseDTO.setLast_active_date(detector.getLastActiveDate());
        detectorResponseDTO.setMessage("Detector successfully added");
        return detectorResponseDTO;
    }*/
}
