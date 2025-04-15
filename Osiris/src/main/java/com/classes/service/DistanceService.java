package com.classes.service;

import com.classes.dao.ICityDAO;
import com.classes.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    @Autowired
    private ICityDAO cityDBDAO;

    // Haversine formula to calculate the distance between two cities
    public double calculerDistance(Long cityId1, Long cityId2) {
        // Fetch cities by ID using CityDAO
        City city1 = cityDBDAO.getCityById(cityId1);
        City city2 = cityDBDAO.getCityById(cityId2);

        // Ensure both cities are available before calculating distance
        if (city1 != null && city2 != null) {
            return calculateDistance(city1, city2);
        } else {
            System.out.println("One or both cities were not found.");
            return 0; // Return 0 if cities not found
        }
    }

    // Separate method to calculate the distance between two cities
    private double calculateDistance(City city1, City city2) {
        final double R = 6371.0; // Radius of the Earth in km
        double lat1 = Math.toRadians(city1.getLatitude());
        double lon1 = Math.toRadians(city1.getLongitude());
        double lat2 = Math.toRadians(city2.getLatitude());
        double lon2 = Math.toRadians(city2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return R * c;
    }
}
