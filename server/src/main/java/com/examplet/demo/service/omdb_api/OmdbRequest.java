package com.examplet.demo.service.omdb_api;

import javax.validation.constraints.Null;

public class OmdbRequest {
    private String code= null;
    private Integer year= null;
    private String search = null;
    private Integer page= null;

    public OmdbRequest(String code, Integer year,  String search, Integer page) {
        this.code = code;
        this.year = year;
        this.page = page;
        this.search = search;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
