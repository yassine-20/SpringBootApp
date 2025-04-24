package com.classes.dao;

import com.classes.model.City;
import com.classes.model.CityRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDBDAO {

    private final JdbcTemplate jdbcTemplate;

    public CityDBDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> findAllCities() {
        String sql = "SELECT * FROM city";
        return jdbcTemplate.query(sql, new CityRowMapper());
    }

    public City findCityById(Long id) {
        String sql = "SELECT * FROM city WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CityRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if no city is found
        }
    }

    // Insert a new city
    public int saveCity(City city) {
        String sql = "INSERT INTO city (id, name, latitude, longitude) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, city.getId(), city.getName(), city.getLatitude(), city.getLongitude());
    }
}
