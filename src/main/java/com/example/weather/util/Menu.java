package com.example.weather.util;

//import com.example.weather.service.WeatherService;
import com.example.weather.service.SimpleWeatherService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    private final SimpleWeatherService weatherService;

    public Menu(SimpleWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        String[] cities = {"Chicago", "Overland Park", "Dallas"};

        while (true) {
            System.out.println("\nWeather Dashboard");
            for (int i = 0; i < cities.length; i++) {
                int option=i+1;
                System.out.println("Option"+option+" "+cities[i]);
            }
            System.out.println("for Exit this enter 0");
            System.out.print("Choose a city: ");
            int choice = scanner.nextInt();

            if (choice == 0) break;
            if (choice > 0 && choice <= cities.length) {
                weatherService.displayWeather(cities[choice - 1]);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Goodbye!");
    }
}
