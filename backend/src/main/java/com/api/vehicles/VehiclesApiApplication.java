package com.api.vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesApiApplication.class, args);
        System.out.println("=================================");
        System.out.println("API de Vehículos iniciada");
        System.out.println("Puerto: 8080");
        System.out.println("URL: http://localhost:8080/api/vehicles");
        System.out.println("=================================");
    }
}
