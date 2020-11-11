package com.examplet.demo.service.omdb_api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


public class OmbdRestTemplate extends RestTemplate {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder
                .build();
    }
}
