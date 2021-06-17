package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitiesDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public CitiesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> getAllCities() {
        return jdbcTemplate.query("SELECT * FROM cities", new BeanPropertyRowMapper<>(City.class));

    }

    public City findCityById(int id) {

        return jdbcTemplate.query("SELECT * FROM cities WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(City.class))
                .stream()
                .findAny().orElse(null);

    }

    public void updateCity(int id, City updatedCity) {
        jdbcTemplate.update("UPDATE  cities SET code=? WHERE id=?", updatedCity.getCode(), id);
    }

    public void createNewCity(City city) {
       jdbcTemplate.update("INSERT INTO cities(code) VALUES (?)", city.getCode());
    }

    public void delete(int id) {
       jdbcTemplate.update("DELETE  FROM cities WHERE id=?", id);
    }
}
