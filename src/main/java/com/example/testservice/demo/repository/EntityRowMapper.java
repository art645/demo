package com.example.testservice.demo.repository;

import com.example.testservice.demo.model.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityRowMapper implements RowMapper<Entity> {
    @Override
    public Entity mapRow(ResultSet rs, int i) throws SQLException {
        return new Entity(
                rs.getInt("id"),
                rs.getString("value"));
    }
}
