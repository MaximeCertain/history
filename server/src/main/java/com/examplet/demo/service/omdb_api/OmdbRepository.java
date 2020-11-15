package com.examplet.demo.service.omdb_api;

import com.examplet.demo.service.omdb_api.pojo.Movie;
import com.examplet.demo.service.omdb_api.pojo.Movies;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OmdbRepository {
    private final static String BASE_URL = "http://www.omdbapi.com/";
    private final static String API_KEY = "81c42988";

    /**
     * Formation collection de Movie
     * @param omdbRequest
     * @return List<Movie>
     */
    public List<Movie> getMovies(OmdbRequest omdbRequest) {

        String uri = (new GetUriFromRequest().execute(omdbRequest));
        OmbdRestTemplate restTemplate = new OmbdRestTemplate();

        ResponseEntity<Movies> rateResponse =
                restTemplate.exchange(uri,
                        HttpMethod.GET, null, new ParameterizedTypeReference<Movies>() {
                        });

        return rateResponse.getBody().getMovies();
    }

    /**
     * Envoi d'une chaine directement
     * @param omdbRequest
     * @return String
     */
    public String getMovie(OmdbRequest omdbRequest) {

        String uri = (new GetUriFromRequest().execute(omdbRequest));
        OmbdRestTemplate restTemplate = new OmbdRestTemplate();

        String result = restTemplate.getForObject(uri, String.class);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        System.out.println(responseEntity);
        return responseEntity.toString();

    }


}
