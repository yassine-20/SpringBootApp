package com.classes;

import com.classes.JdbcConfig;
import com.classes.dao.CityDBDAO;
import com.classes.service.DistanceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@Component
public class Main {

    private final DistanceService distanceService;
    private final Scanner scanner;

    @Autowired
    public Main(CityDBDAO cityDBDAO, DistanceService distanceService) {
        this.distanceService = distanceService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter the ID of the first city (e.g., 1 for Oujda): ");
        Long cityId1 = scanner.nextLong();

        System.out.println("Enter the ID of the second city (e.g., 2 for Rabat): ");
        Long cityId2 = scanner.nextLong();

        try {
            double distance = distanceService.calculerDistance(cityId1, cityId2);
            System.out.println("Calculated distance between city " + 3 + " and city " + 3 + ": " + distance + " km");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class); // Ensure correct context setup
        Main mainApp = context.getBean(Main.class);
        mainApp.run();
    }
}
