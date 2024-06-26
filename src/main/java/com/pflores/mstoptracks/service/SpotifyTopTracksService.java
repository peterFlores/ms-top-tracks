package com.pflores.mstoptracks.service;

import com.pflores.mstoptracks.client.ISpotifyClientTopTracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SpotifyTopTracksService {

    @Autowired
    private ISpotifyClientTopTracks spotifyClientTopTracks;

    public Map<String, Object> fetchTopTracks(String id) {
        return spotifyClientTopTracks.fetchTopTracks(id);
    }
}
