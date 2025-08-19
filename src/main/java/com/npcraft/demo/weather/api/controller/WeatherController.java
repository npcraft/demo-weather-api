package com.npcraft.demo.weather.api.controller;

import com.npcraft.demo.weather.api.dto.view.WeatherViewDto;
import com.npcraft.demo.weather.api.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
 
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherViewDto> getWeatherData(@RequestParam String city, @RequestParam String apiKey) {
        WeatherViewDto weatherViewDto = weatherService.getWeatherForCity(city, apiKey);

        if (weatherViewDto != null) {
            return ResponseEntity.ok(weatherViewDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
