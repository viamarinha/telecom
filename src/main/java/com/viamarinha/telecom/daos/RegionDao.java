package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RegionDao {

    private CitiesDao citiesDao;

    @Autowired
    public RegionDao(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/telecom";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Mara@2016";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Region> getAllRegions() {
        List<Region> regions = new ArrayList<>();
        Region region = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM regions");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                region = new Region();
                region.setId(resultSet.getInt("id"));
                region.setCode(resultSet.getString("code"));
                region.setShortName(resultSet.getString("shortName"));
                region.setCity(citiesDao.findCityById(resultSet.getInt("cityid")));

                regions.add(region);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regions;
    }

    public Region getRegionById(int id) {
        Region region = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM regions WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            region = new Region();
            region.setId(resultSet.getInt("id"));
            region.setCode(resultSet.getString("code"));
            region.setShortName(resultSet.getString("shortName"));
            region.setCity(citiesDao.findCityById(resultSet.getInt("cityid")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return region;
    }
}
