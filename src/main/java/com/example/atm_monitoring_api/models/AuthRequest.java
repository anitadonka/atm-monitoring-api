package com.example.atm_monitoring_api.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {
    // Getters and Setters
    private String username;
    private String password;
    private String deviceId; // Keep this if you still need device validation

}
