package com.example.atm_monitoring_api.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "failure_logs")
public class FailureLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String transactionType; // e.g., "DEPOSIT", "WITHDRAWAL", "BALANCE_INQUIRY"

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String errorDescription;

    @Column
    private String deviceInfo; // Additional info about the device or system

    // Constructors, getters, setters

    public FailureLog() {}

    public FailureLog(String transactionType, LocalDateTime timestamp, String errorDescription, String deviceInfo) {
        this.transactionType = transactionType;
        this.timestamp = timestamp;
        this.errorDescription = errorDescription;
        this.deviceInfo = deviceInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
