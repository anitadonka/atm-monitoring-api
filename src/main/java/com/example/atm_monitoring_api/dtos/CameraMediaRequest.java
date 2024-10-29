package com.example.atm_monitoring_api.dtos;



import java.time.LocalDateTime;

public class CameraMediaRequest {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CameraMediaRequest() {}

    public CameraMediaRequest(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
