package com.classes.model;

public class City {
    private Long id;  // Add ID field
    private String name;
    private double latitude;
    private double longitude;

    // Constructor to initialize all fields
    public City(Long id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter methods for all fields
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
