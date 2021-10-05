package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.City;
import com.viamarinha.telecom.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CitiesDao {

    JdbcTemplate jdbcTemplate;
    Map<Integer, City> cityMap = new HashMap<>();

    @Autowired
    public CitiesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> getAllCities() {
        return jdbcTemplate.query("SELECT c.id , c.code, rg.id as region_id, rg.code as region_code,rg.shortName FROM cities c LEFT JOIN regions rg on c.id = rg.cityid ",
                (ResultSetExtractor<List<City>>) rs -> {

                    createCity(rs, cityMap);
                    return new ArrayList<>(cityMap.values());
                });
    }

    public City findCityById(int id) {

        return jdbcTemplate.query("SELECT c.id , c.code, rg.id as region_id, rg.code as region_code," +
                                "rg.shortName FROM cities c LEFT JOIN regions rg on c.id = rg.cityid WHERE c.id=?",

                        (ResultSetExtractor<List<City>>) rs -> {

                            createCity(rs, cityMap);
                            return new ArrayList<City>(cityMap.values());
                        }, id)
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


    private void createCity(ResultSet rs, Map<Integer, City> cityMap) throws SQLException {
        while (rs.next()) {
            int cityId = rs.getInt("id");
            String code = rs.getString("code");
            int regionId = rs.getInt("region_id");
            String regionCode = rs.getString("region_code");
            String shortname = rs.getString("shortName");

            City city = cityMap.get(cityId);
            if (city == null) {
                city = new City(cityId, code);
                cityMap.put(cityId, city);
            }
            if (city.getRegions() == null) {
                city.setRegions(new ArrayList<>());
            }

            if (regionId != 0) {
                Region region = new Region();
                region.setId(regionId);
                region.setCode(regionCode);
                region.setShortName(shortname);
                region.setCityId(cityId);
                city.getRegions().add(region);
            }

        }
    }
}