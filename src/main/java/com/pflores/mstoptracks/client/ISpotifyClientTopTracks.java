package com.pflores.mstoptracks.client;


import com.pflores.mstoptracks.configuration.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "spotifyClient", url = "${spotify.api.url}", configuration = FeignClientConfiguration.class)
public interface ISpotifyClientTopTracks {

    @GetMapping(value = "v1/artists/{id}/top-tracks")
    Map<String, Object> fetchTopTracks(@PathVariable(name = "id") String id);
}