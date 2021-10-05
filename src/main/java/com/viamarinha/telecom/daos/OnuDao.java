package com.viamarinha.telecom.daos;

import com.viamarinha.telecom.models.Onu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OnuDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OnuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Onu> getAllOnus() {


        return jdbcTemplate.query("SELECT * FROM onus", new BeanPropertyRowMapper<>(Onu.class));
    }

    public Onu getOnuById(int id) {
        return jdbcTemplate.query("SELECT * FROM onus WHERE id = ?", new BeanPropertyRowMapper<>(Onu.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }

    public void createOnu(Onu onu) {
        jdbcTemplate.update("INSERT INTO onus( serialNumber, shortName, buildingid) VALUES (?,?,?)",
                onu.getSerialNumber(), onu.getShortName(), onu.getBuildingId());
    }

    public void updateOnu(int id, Onu updatedOnu) {
        jdbcTemplate.update("UPDATE onus SET serialnumber = ?, shortname = ?, buildingid = ? WHERE id = ?",
                updatedOnu.getSerialNumber(), updatedOnu.getShortName(), updatedOnu.getBuildingId(), id);
    }

    public void deleteOnu(int id) {
        jdbcTemplate.update("DELETE FROM onus WHERE id = ?", id);
    }
}
