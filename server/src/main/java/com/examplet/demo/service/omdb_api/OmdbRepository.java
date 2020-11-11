package com.examplet.demo.service.omdb_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OmdbRepository {
    private final static String BASE_URL = "http://www.omdbapi.com/";
    private final static String API_KEY = "81c42988";

    public String getMovies(OmdbRequest omdbRequest) {

        String uri = (new GetUriFromRequest().execute(omdbRequest));
        OmbdRestTemplate restTemplate = new OmbdRestTemplate();

        String result = restTemplate.getForObject(uri, String.class);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);


        return result;
    }


}
