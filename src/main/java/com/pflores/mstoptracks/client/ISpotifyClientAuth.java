package com.pflores.mstoptracks.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "spotifyAuthClient", url = "${spotify.account.api.url}")
public interface ISpotifyClientAuth {

    @PostMapping(value = "/api/token", consumes = "application/x-www-form-urlencoded")
    Map<String, Object> getToken(@RequestBody Map<String, ?> formParams);
}