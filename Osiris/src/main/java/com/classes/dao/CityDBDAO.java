package com.classes.dao;

import com.classes.model.City;
import org.springframework.stereotype.Component;

@Component
public class CityDBDAO implements ICityDAO  {

    // Static method to return a static City object based on ID
    public City getCityById(Long id) {
        // Returning static City objects for demonstration
        if (id == 1L) {
            return new City(1L, "Casa", 40.7128, -74.0060); // Static object for Casa
        } else if (id == 2L) {
            return new City(2L, "Tanger", 34.0522, -118.2437); // Static object for Tanger
        } else {
            return null; // Return null if no city is found for the given ID
        }
    }

    // Static method to return a City by Name
    public City getCityByName(String name) {
        // Return a static city based on the name
        if ("Paris".equalsIgnoreCase(name)) {
            return new City(1L, "Casa", 48.8566, 2.3522); // Static object for Paris
        } else if ("London".equalsIgnoreCase(name)) {
            return new City(2L, "Tanger", 51.5074, -0.1278); // Static object for London
        } else {
            return null; // Return null if no city is found for the given name
        }
    }
}
