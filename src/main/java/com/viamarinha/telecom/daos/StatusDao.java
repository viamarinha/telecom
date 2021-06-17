package com.viamarinha.telecom.daos;


import com.viamarinha.telecom.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StatusDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Status> getAllStatuses() {

        return jdbcTemplate.query("SELECT * FROM statuses", new BeanPropertyRowMapper<>(Status.class));
    }

    public Status getStatusById(int id) {
        return jdbcTemplate.query("SELECT * FROM statuses WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Status.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public void addNewStatus(Status status) {
        jdbcTemplate.update("INSERT INTO statuses(active, inservice, functional) VALUES(?,?,?)",
                status.isActive(), status.isInService(), status.isFunctional());
    }

    public void update(Status status, int id) {
        jdbcTemplate.update("UPDATE statuses SET active=?, inservice=?, functional=? WHERE id=?",
                status.isActive(), status.isInService(), status.isFunctional(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM statuses WHERE id = ?", id);
    }
}
