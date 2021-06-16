package com.viamarinha.telecom.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Region {
    private int id;
    private String code;
    private String shortName;
    private City city;

    @Autowired
    public Region(City city) {
        this.city = city;
    }

    public Region() {
    }

    public Region(String code, String shortName, City city) {
        this.code = code;
        this.shortName = shortName;
        this.city = city;
    }

    public Region(String code, String shortName) {
        this.code = code;
        this.shortName = shortName;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
