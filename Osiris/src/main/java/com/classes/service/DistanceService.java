package com.classes.service;

import com.classes.dao.CityDBDAO;
import com.classes.dao.DistanceDBDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final CityDBDAO cityDBDAO;
    private final DistanceDBDAO distanceDBDAO;

    @Autowired
    public DistanceService(CityDBDAO cityDBDAO, DistanceDBDAO distanceDBDAO) {
        this.cityDBDAO = cityDBDAO;
        this.distanceDBDAO = distanceDBDAO;
    }

    // Method to get distance between two cities from database
    public double calculerDistance(Long cityId1, Long cityId2) {
        // Ensure we always query with smaller ID first for consistency
        Long smallerId = Math.min(cityId1, cityId2);
        Long largerId = Math.max(cityId1, cityId2);

        // Get the distance from database
        Double distance = distanceDBDAO.findDistanceBetweenCities(smallerId, largerId);

        if (distance == null) {
            throw new IllegalArgumentException("Distance between these cities not found in database.");
        }

        return distance;
    }
}