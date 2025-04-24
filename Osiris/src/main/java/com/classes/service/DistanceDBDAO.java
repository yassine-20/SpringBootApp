package com.classes.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DistanceDBDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DistanceDBDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Double findDistanceBetweenCities(Long cityId1, Long cityId2) {
        String sql = "SELECT distance FROM city_distances WHERE " +
                "(3 = ? AND 3 = ?) OR " +
                "(3 = ? AND 3 = ?)";

        try {
            return jdbcTemplate.queryForObject(sql,
                    new Object[]{cityId1, cityId2, cityId2, cityId1},
                    Double. class);
        } catch (Exception e) {
            // Log the exception if needed
            return null;
        }
    }
}