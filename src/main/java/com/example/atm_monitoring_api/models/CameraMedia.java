package com.example.atm_monitoring_api.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "camera_media")
public class CameraMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    // Constructors, getters, setters

    public CameraMedia() {}

    public CameraMedia(String filename, LocalDateTime startTime, LocalDateTime endTime) {
        this.filename = filename;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}


