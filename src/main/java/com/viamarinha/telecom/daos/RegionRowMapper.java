package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRowMapper implements RowMapper<Region> {

    @Override
    public Region mapRow(ResultSet resultSet, int i) throws SQLException {
        Region region = new Region();
        region.setId(resultSet.getInt("id"));
        region.setCode(resultSet.getString("code"));
       // region.setCity(resultSet.getObject("cityid", City.class));

        return region;
    }
}
