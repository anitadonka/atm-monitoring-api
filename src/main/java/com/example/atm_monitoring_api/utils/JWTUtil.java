package com.example.atm_monitoring_api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String SECRET_KEY = "secret"; // Use a more secure key in production
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
    // Generate JWT Token
    public static String generateToken(String username, String deviceId) {
        return Jwts.builder()
                .setSubject(username)
                .claim("deviceId", deviceId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    // Validate the token
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Check if the token is expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    // Extract username from token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
    // Extract expiration date from token
    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
    // Extract all claims from token
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}