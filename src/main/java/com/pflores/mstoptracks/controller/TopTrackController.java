package com.pflores.mstoptracks.controller;

import com.pflores.mstoptracks.service.SpotifyTopTracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/ms-top-tracks")
@RestController
public class TopTrackController {

    @Autowired
    private SpotifyTopTracksService spotifyTopTracksService;

    @GetMapping("/artists/{id}/top-tracks")
    public Map fetchTopTracks(@PathVariable(name = "id") String id) {
        return spotifyTopTracksService.fetchTopTracks(id);
    }
}
