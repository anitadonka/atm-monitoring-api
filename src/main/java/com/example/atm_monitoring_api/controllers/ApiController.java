package com.example.atm_monitoring_api.controllers;


import com.example.atm_monitoring_api.dtos.CameraMediaRequest;
import com.example.atm_monitoring_api.dtos.FailureResponse;
import com.example.atm_monitoring_api.dtos.TransactionBreakdownResponse;
import com.example.atm_monitoring_api.services.*;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private FailureLogService failureLogService;
    @Autowired
    private CameraMediaService cameraMediaService;

    @GetMapping("/customers/count")
    public ResponseEntity<Integer> getCustomerCount() {
        return ResponseEntity.ok(customerService.countUniqueCustomersLast24Hours());
    }

    @GetMapping("/transactions/breakdown")
    public ResponseEntity<TransactionBreakdownResponse> getTransactionBreakdown(LocalDateTime startDate, LocalDateTime endDate) {
        return ResponseEntity.ok(transactionService.getTransactionBreakdown(startDate, endDate));
    }

    @GetMapping("/failures")
    public ResponseEntity<List<FailureResponse>> getFailures(
            @RequestParam(required = false) String transactionType,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(failureLogService.getFailures(start, end));
    }

    @PostMapping("/media/download")
    public ResponseEntity<Resource> downloadMedia(
            @RequestBody CameraMediaRequest request) {
        Resource media = (Resource) cameraMediaService.getMediaFilesInRange(request.getStartTime(),request.getEndTime());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(media);
    }
}
