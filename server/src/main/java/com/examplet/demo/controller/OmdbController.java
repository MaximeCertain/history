package com.examplet.demo.controller;

import com.examplet.demo.service.omdb_api.OmdbRepository;
import com.examplet.demo.service.omdb_api.OmdbRequest;
import com.examplet.demo.service.omdb_api.pojo.Movie;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)

public class OmdbController {

    @Autowired
    OmdbRepository omdbRepository;

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Movie> getMovies() throws ParseException {
        OmdbRequest omdbRequest = new OmdbRequest(null, null, "Raiders", 2);
        Iterable<Movie> movies = omdbRepository.getMovies(omdbRequest);
        return movies;
    }

    @GetMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMovie() {
        OmdbRequest omdbRequest = new OmdbRequest("blade", 2017, null, null);
        String movie = omdbRepository.getMovie(omdbRequest);
        return movie;
    }

    @GetMapping(value = "/moderator")
    @Secured("ROLE_MODERATOR")
    public String moderatorMessage() {
        return "texte pour les modérateurs seulement";
    }
}