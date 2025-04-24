package com.classes;

import com.classes.model.City;
import com.classes.model.CityRowMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "com.classes")
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Create the 'city' table
        String schemaSql = "CREATE TABLE IF NOT EXISTS city (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "latitude DOUBLE, " +
                "longitude DOUBLE);";
        jdbcTemplate.execute(schemaSql);

        // Insert two cities using a PreparedStatementSetter
        String insertSql = "INSERT INTO city (id, name, latitude, longitude) VALUES (?, ?, ?, ?)";

        // First City (New York)
        jdbcTemplate.update(insertSql, (PreparedStatementSetter) ps -> {
            ps.setInt(1, 1);
            ps.setString(2, "New York");
            ps.setDouble(3, 40.7128);
            ps.setDouble(4, -74.0060);
        });

        // Second City (Los Angeles)
        jdbcTemplate.update(insertSql, (PreparedStatementSetter) ps -> {
            ps.setInt(1, 2);
            ps.setString(2, "Los Angeles");
            ps.setDouble(3, 37.0522);
            ps.setDouble(4, -118.2437);
        });

        return jdbcTemplate;
    }
}
