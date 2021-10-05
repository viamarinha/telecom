package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.mappers.RegionRowMapper;
import com.viamarinha.telecom.models.Address;
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
public class RegionDao {


    Map<Integer, Region> regionMap = new HashMap<>();
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Region> getAllRegions() {

        return jdbcTemplate.query(
                "SELECT r.id , r.code, r.shortName, r.cityid, a.id as addressId, a.country, a.province, a.street, a.civicNumber, a.cityid FROM regions r LEFT JOIN addresses a " +
                        "on r.id = a.regionid ",
                (ResultSetExtractor<List<Region>>) rs -> {

                    getRegion(rs, regionMap);

                    return new ArrayList<>(regionMap.values());
                });

    }



    public Region getRegionById(int id) {

        return jdbcTemplate.query(
                "SELECT r.id , r.code, r.shortName, r.cityid, a.id as addressId, a.country, a.province, a.street, a.civicNumber, a.cityid FROM regions r INNER JOIN addresses a " +
                        "on r.id = a.regionid WHERE r.id = ?",
                (ResultSetExtractor<List<Region>>) rs -> {

                    getRegion(rs, regionMap);

                    return new ArrayList<>(regionMap.values());
                }, id)
                .stream()
                .findAny()
                .orElse(null);
    }

    public void updateRegion(int id, Region region) {

        jdbcTemplate.update("UPDATE  regions SET code =?, shortName =? WHERE id=?",
                region.getCode(), region.getShortName(), id);
    }

    public void addNewRegion(Region region) {
        jdbcTemplate.update("INSERT INTO regions(code, shortname, cityid) VALUES (?,?,?)", region.getCode(), region.getShortName(), region.getCityId());
    }

    private void getRegion(ResultSet rs, Map<Integer, Region> regionMap) throws SQLException {

        while (rs.next()) {

            int regionId = rs.getInt("id");
            String code = rs.getString("code");
            String shortName = rs.getString("shortName");
            int cityId = rs.getInt("cityid");
            int addressId = rs.getInt("addressId");
            String country = rs.getString("country");
            String province = rs.getString("province");
            String street = rs.getString("street");
            String civicNumber = rs.getString("civicNumber");


            Region region = regionMap.get(regionId);
            if (region == null) {
                region = new Region(regionId, shortName, code, cityId);
                regionMap.put(regionId, region);

            }
            if (region.getAddressees() == null) {
                region.setAddressees(new ArrayList<>());
            }
            if (addressId != 0) {
                Address address = new Address(addressId, country, regionId, province, street, civicNumber);
                region.getAddressees().add(address);
            }
        }
    }
}
