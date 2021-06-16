package com.viamarinha.telecom.daos;


import com.viamarinha.telecom.models.Status;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StatusDao {


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

    public List<Status> getAllStatuses() {

        List<Status> statuses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM statuses");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = new Status();

                status.setId(resultSet.getInt("id"));
                status.setActive(resultSet.getBoolean("active"));
                status.setInService(resultSet.getBoolean("inservice"));
                status.setFunctional(resultSet.getBoolean("functional"));

                statuses.add(status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statuses;
    }

    public Status getStatusById(int id) {
        Status status = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  statuses WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            status = new Status();
            status.setId(resultSet.getInt("id"));
            status.setActive(resultSet.getBoolean("active"));
            status.setInService(resultSet.getBoolean("inservice"));
            status.setFunctional(resultSet.getBoolean("functional"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return status;
    }

    public void addNewStatus(Status status) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO statuses(active, inservice, functional) VALUES(?,?,?)");
            preparedStatement.setBoolean(1, status.isActive());
            preparedStatement.setBoolean(2, status.isInService());
            preparedStatement.setBoolean(3, status.isFunctional());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Status status, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE statuses SET active=?, inservice=?, functional=? WHERE id=?");
            preparedStatement.setBoolean(1, status.isActive());
            preparedStatement.setBoolean(2, status.isInService());
            preparedStatement.setBoolean(3, status.isFunctional());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM statuses WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
