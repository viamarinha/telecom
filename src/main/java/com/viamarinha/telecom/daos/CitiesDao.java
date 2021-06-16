package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.City;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CitiesDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/telecom" ;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Mara@2016";

    private static Connection connection;

    static{
       try{
           Class.forName("org.postgresql.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       try{
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cities");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCode(resultSet.getString("code"));
                cities.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cities;
    }

    public City findCityById(int id) {
        City city = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cities WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            city = new City();
            city.setId(resultSet.getInt("id"));
            city.setCode(resultSet.getString("code"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return city;
    }

    public void updateCity(int id, City updatedCity) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cities SET code=? WHERE id=?");
            preparedStatement.setString(1, updatedCity.getCode());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createNewCity(City city) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cities(code) VALUES (?)");
            preparedStatement.setString(1,city.getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM cities WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
