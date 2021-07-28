package com.viamarinha.telecom.models;


public class Region {
    private int id;
    private String code;
    private String shortName;
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Region() {
    }

    public Region(String code, String shortName) {
        this.code = code;
        this.shortName = shortName;

    }

    public Region(int id, String code, String shortName) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}