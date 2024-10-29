package com.example.atm_monitoring_api.dtos;



import java.time.LocalDateTime;

public class FailureResponse {

    private String transactionType;
    private LocalDateTime timestamp;
    private String errorDescription;
    private String deviceInfo;

    public FailureResponse() {}

    public FailureResponse(String transactionType, LocalDateTime timestamp, String errorDescription, String deviceInfo) {
        this.transactionType = transactionType;
        this.timestamp = timestamp;
        this.errorDescription = errorDescription;
        this.deviceInfo = deviceInfo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}

