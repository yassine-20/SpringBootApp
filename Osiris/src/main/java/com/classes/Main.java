package com.classes;

import com.classes.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Main implements CommandLineRunner {

    @Autowired
    private DistanceService distanceService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Calculate the distance between cities (IDs passed to the service)
        double distance = distanceService.calculerDistance(1L, 2L); // Example: Casa  (ID 1) and Tanger (ID 2)

        // Print the result
        System.out.println("Calculated distance: " + distance + " km");
    }
}
