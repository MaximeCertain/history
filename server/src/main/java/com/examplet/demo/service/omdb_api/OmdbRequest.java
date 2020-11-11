package com.examplet.demo.service.omdb_api;

public class OmdbRequest {
    private String code;
    private Integer year;

    public OmdbRequest(String code, Integer year) {
        this.code = code;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
