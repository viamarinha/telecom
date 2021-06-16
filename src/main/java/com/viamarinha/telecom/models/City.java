package com.viamarinha.telecom.models;

import org.springframework.stereotype.Component;

@Component
public class City {

    private int id;
    private String code;

    public City() {
    }

    public City(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public City(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
