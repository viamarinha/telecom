package com.viamarinha.telecom.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class City {

    private int id;
    private String code;
    private List<Region> regions;

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

    public List<Region> getRegions() {
        if(regions == null){
            regions = new ArrayList<>();
        }
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", regions=" + regions +
                '}';
    }
}
