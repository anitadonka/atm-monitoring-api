package com.example.atm_monitoring_api.services;
import com.example.atm_monitoring_api.models.CameraMedia;
import com.example.atm_monitoring_api.repositories.CameraMediaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CameraMediaService {

    private final CameraMediaRepository cameraMediaRepository;

    public CameraMediaService(CameraMediaRepository cameraMediaRepository) {
        this.cameraMediaRepository = cameraMediaRepository;
    }

    public List<CameraMedia> getMediaFilesInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return cameraMediaRepository.findMediaInDateRange(startDate, endDate);
    }

    public void storeMediaFile(CameraMedia media) {
        cameraMediaRepository.save(media);
    }
}
