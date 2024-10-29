package com.example.atm_monitoring_api.services;



import com.example.atm_monitoring_api.dtos.FailureResponse;
import com.example.atm_monitoring_api.repositories.FailureLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FailureLogService {

    private final FailureLogRepository failureLogRepository;

    public FailureLogService(FailureLogRepository failureLogRepository) {
        this.failureLogRepository = failureLogRepository;
    }

    public List<FailureResponse> getFailures(LocalDateTime startDate, LocalDateTime endDate) {
        return failureLogRepository.findFailuresInDateRange(startDate, endDate)
                .stream()
                .map(log -> new FailureResponse(
                        log.getTransactionType(),
                        log.getTimestamp(),
                        log.getErrorDescription(),
                        log.getDeviceInfo()))
                .collect(Collectors.toList());
    }
}

