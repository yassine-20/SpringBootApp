package com.classes.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();
        city.setId(rs.getLong("id"));
        city.setName(rs.getString("name"));
        city.setLatitude(rs.getDouble("latitude"));
        city.setLongitude(rs.getDouble("longitude"));
        return city;
    }
}
