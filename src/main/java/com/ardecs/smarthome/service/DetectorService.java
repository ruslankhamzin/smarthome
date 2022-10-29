package com.ardecs.smarthome.service;

import com.ardecs.smarthome.dto.DetectorDTO;
import com.ardecs.smarthome.dto.DetectorResponseDTO;
import com.ardecs.smarthome.dto.NotificationDTO;
import com.ardecs.smarthome.entity.Detector;
import com.ardecs.smarthome.repository.DetectorRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
public class DetectorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetectorService.class);
    private static final ModelMapper MAPPER = new ModelMapper();
    @Autowired
    private DetectorRepository detectorRepository;
    @Autowired
    private NotificationService notificationService;

    public DetectorResponseDTO create(DetectorDTO detectorDTO) {
        Detector detector = mapToDetector(detectorDTO);
        detectorRepository.save(detector);
        LOGGER.info("Detector has been saved with data: " + detector);
        return mapToDetectorResponseDTO(detector);
    }

    private Detector mapToDetector(DetectorDTO detectorDTO) {
        Detector detector = MAPPER.map(detectorDTO, Detector.class);
        setDetectorFields(detector);
        return detector;
    }

    private void setDetectorFields(Detector detector) {
        detector.setId(String.valueOf(UUID.randomUUID()));
        detector.setActive(true);
        detector.setRegistrationDate(Instant.now());
        detector.setLastActiveDate(Instant.now());
    }

    private DetectorResponseDTO mapToDetectorResponseDTO(Detector detector) {
        DetectorResponseDTO detectorResponseDTO = MAPPER.map(detector, DetectorResponseDTO.class);
        detectorResponseDTO.setMessage("The detector has been added");
        LOGGER.info("Response with data: " + detectorResponseDTO);
        return detectorResponseDTO;
    }

    @Transactional
    public String activate(NotificationDTO notificationDTO) {
        detectorRepository.updateLastActiveDateForDetector(notificationDTO.getDetector().getId(), Instant.now());
        return notificationService.send(notificationDTO);
    }
}
