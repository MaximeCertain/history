package com.examplet.demo.service.omdb_api;

import java.util.HashMap;
import java.util.Map;

public class GetUriFromRequest {
    private final static String BASE_URL = "http://www.omdbapi.com/";
    private final static String API_KEY = "81c42988";

    /**
     * Forme une uri à partir d'un objet requête
     * @param omdbRequest
     * @return
     */
    public String execute(OmdbRequest omdbRequest) {

        StringBuilder uri = new StringBuilder(BASE_URL);
        HashMap<String, String> requestUris = new HashMap<String, String>();

        if (omdbRequest.getYear() != null) {
            requestUris.put("y", omdbRequest.getYear().toString());
        }
        if (omdbRequest.getCode() != null) {
            requestUris.put("t", omdbRequest.getCode());
        }

        char accolade = '?';
        for (Map.Entry<String, String> item : requestUris.entrySet()) {
            uri.append(accolade + item.getKey() + "=" + item.getValue());
            accolade = '&';
        }
        uri.append(accolade + "apikey=" + API_KEY);

        return uri.toString();
    }
}
