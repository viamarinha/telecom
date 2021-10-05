package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.Building;
import com.viamarinha.telecom.models.Onu;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
public class BuildingDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BuildingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Building> getAllBuildings() {


        return jdbcTemplate.query("SELECT b.id, b. shortname, b.adressid, o.id as onuid, o.serialnumber, o.shortname as onushortname , o.buildingid" +
                " FROM buildings b LEFT JOIN onus o on b.id = o.buildingid", resultSet -> {

            Map<Integer, Building> buildingMap = new HashMap<>();

            while (resultSet.next()) {
                int buildingId = resultSet.getInt("id");
                String buildingShorName = resultSet.getString("shortname");
                int addressId = resultSet.getInt("adressid");

                int onuId = resultSet.getInt("onuid");
                int onuSerialNumber = resultSet.getInt("serialnumber");
                String onuShortName = resultSet.getString("onushortname");
                int onuBuildingId = resultSet.getInt("buildingid");

                Building building = buildingMap.get(buildingId);
                if (building == null) {
                    building = new Building(buildingId, buildingShorName, addressId);
                    buildingMap.put(buildingId, building);
                }
                if (building.getOnuList() == null) {
                    building.setOnuList(new ArrayList<>());
                }
                if (onuId != 0) {
                    Onu onu = new Onu(onuId, onuSerialNumber, onuShortName, onuBuildingId);
                    building.getOnuList().add(onu);
                }


            }
            return new ArrayList<>(buildingMap.values());
        });
    }


    public Building getBuildingById(int id) {

        return jdbcTemplate.query("SELECT b.id, b. shortname, b.adressid, o.id as onuid, o.serialnumber, o.shortname as onushortname , o.buildingid" +
                " FROM buildings b LEFT JOIN onus o on b.id = o.buildingid where b.id = ?", resultSet -> {

            Map<Integer, Building> buildingMap = new HashMap<>();

            while (resultSet.next()) {
                int buildingId = resultSet.getInt("id");
                String buildingShorName = resultSet.getString("shortname");
                int addressId = resultSet.getInt("adressid");

                int onuId = resultSet.getInt("onuid");
                int onuSerialNumber = resultSet.getInt("serialnumber");
                String onuShortName = resultSet.getString("onushortname");
                int onuBuildingId = resultSet.getInt("buildingid");

                Building building = buildingMap.get(buildingId);
                if (building == null) {
                    building = new Building(buildingId, buildingShorName, addressId);
                    buildingMap.put(buildingId, building);
                }
                if (building.getOnuList() == null) {
                    building.setOnuList(new ArrayList<>());
                }
                if (onuId != 0) {
                    Onu onu = new Onu(onuId, onuSerialNumber, onuShortName, onuBuildingId);
                    building.getOnuList().add(onu);
                }


            }
            return (buildingMap.values().stream().findAny().orElse(null));
        }, id);
    }

    public void updateBuilding(int id, Building updatedBuilding) {
        jdbcTemplate.update("UPDATE buildings set shortname = ? where id=?", updatedBuilding.getShortName(),id);

    }

    public void deleteBuilding(int id) {jdbcTemplate.update("DELETE FROM buildings WHERE id=?",id); }
}
