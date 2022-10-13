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
        Detector detector = mappedToDetector(detectorDTO);
        detectorRepository.save(detector);
        LOGGER.info("detector has been saved with data: " + detector);
        return mappedToDetectorResponseDTO(detector);
    }

    private Detector mappedToDetector(DetectorDTO detectorDTO) {
        Detector detector = MAPPER.map(detectorDTO, Detector.class);
        initDetector(detector);
        return detector;
    }

    private Detector initDetector(Detector detector) {
        detector.setId(String.valueOf(UUID.randomUUID()));
        detector.setActive(true);
        detector.setRegistrationDate(Instant.now());
        detector.setLastActiveDate(Instant.now());
        return detector;
    }

    private DetectorResponseDTO mappedToDetectorResponseDTO(Detector detector) {
        DetectorResponseDTO detectorResponseDTO = MAPPER.map(detector, DetectorResponseDTO.class);
        detectorResponseDTO.setMessage("Detector successfully added");
        return detectorResponseDTO;
    }

    public String triggering(NotificationDTO notificationDTO) {
        detectorRepository.updateLastActiveDateForDetector(notificationDTO.getDetectorId().getId(), Instant.now());
        return notificationService.send(notificationDTO);
    }
}
