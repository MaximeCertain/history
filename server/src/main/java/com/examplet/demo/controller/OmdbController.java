package com.examplet.demo.controller;

import com.examplet.demo.service.omdb_api.OmdbRepository;
import com.examplet.demo.service.omdb_api.OmdbRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OmdbController {

    @Autowired
    OmdbRepository omdbRepository;

    @GetMapping("/movies")
    public String getAllRaces() {
        OmdbRequest omdbRequest = new OmdbRequest("blade", 2017);
        String movies = omdbRepository.getMovies(omdbRequest);

      /*  final String uri = "http://www.omdbapi.com/?t=blade&y=2017&apikey=81c42988";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        OmbdConfig ombdConfig = new OmbdConfig();*/
        return movies;
    }
}