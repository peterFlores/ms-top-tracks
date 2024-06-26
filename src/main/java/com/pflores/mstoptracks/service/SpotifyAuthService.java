package com.pflores.mstoptracks.service;

import com.pflores.mstoptracks.client.ISpotifyClientAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SpotifyAuthService {

    @Autowired
    private ISpotifyClientAuth spotifyClientAuth;

    private String accessToken;
    private long expiryTime;

    @Value("${spotify.client.id}")
    private String clientId;

    @Value("${spotify.client.secret}")
    private String clientSecret;

    public String getAccessToken() {
        if (accessToken == null || System.currentTimeMillis() > expiryTime) {
            refreshAccessToken();
        }
        return accessToken;
    }

    private synchronized void refreshAccessToken() {
        if (accessToken == null || System.currentTimeMillis() > expiryTime) {
            Map<String, Object> response = spotifyClientAuth.getToken(Map.of(
                    "grant_type", "client_credentials",
                    "client_id", clientId,
                    "client_secret", clientSecret
            ));
            accessToken = (String) response.get("access_token");
            expiryTime = System.currentTimeMillis() + ((Integer) response.get("expires_in")) * 1000L;
        }
    }
}