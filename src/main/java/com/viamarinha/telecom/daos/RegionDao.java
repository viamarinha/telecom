package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.City;
import com.viamarinha.telecom.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RegionDao {

    private CitiesDao citiesDao;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegionDao(CitiesDao citiesDao, JdbcTemplate jdbcTemplate) {
        this.citiesDao = citiesDao;
        this.jdbcTemplate = jdbcTemplate;
    }




    public List<Region> getAllRegions() {
       return jdbcTemplate.query("SELECT * FROM regions", new BeanPropertyRowMapper<>(Region.class));
    }

    public Region getRegionById(int id) {
      return  jdbcTemplate.query("SELECT * FROM regions WHERE id=?", new Object[]{id},
              new BeanPropertyRowMapper<>(Region.class))
              .stream()
              .findAny()
              .orElse(null);
    }

    public void updateRegion(int id, Region region) {
    }
}
