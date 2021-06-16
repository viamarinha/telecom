package com.viamarinha.telecom.services;

import com.viamarinha.telecom.daos.CitiesDao;
import com.viamarinha.telecom.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {


    private CitiesDao citiesDao;

    @Autowired
    public CitiesService(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
    }

    public List<City> getAllCities() {
        return citiesDao.getAllCities();
    }

    public City findCityById(int id) {
        return citiesDao.findCityById(id);
    }

    public void updateCity(int id, City city) {
        citiesDao.updateCity(id, city);
    }

    public void addNewCity(City city) {
        citiesDao.createNewCity(city);
    }

    public void delete(int id) {
        citiesDao.delete(id);
    }
}
