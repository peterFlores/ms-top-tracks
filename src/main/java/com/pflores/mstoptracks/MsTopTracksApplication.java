package com.pflores.mstoptracks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsTopTracksApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTopTracksApplication.class, args);
    }

}
