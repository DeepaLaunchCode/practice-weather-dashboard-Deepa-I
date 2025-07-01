package com.example.weather.service;

import com.example.weather.model.WeatherData;
import com.example.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimpleWeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    public void displayWeather(String city) {

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?q=%s&appid=%s&units=Imperial", apiUrl, city, apiKey);
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        System.out.println("Here is the WeatherData requested");
        System.out.println("City: " + response.getName());
        System.out.println("Temperature: " + response.getMain().getTemp() + "°F");
        System.out.println("Humidity: " + response.getMain().getHumidity() + "%");
        System.out.println("Description: " + response.getWeather()[0].getDescription());

    }
}
