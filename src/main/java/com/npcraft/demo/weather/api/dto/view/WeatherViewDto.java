package com.npcraft.demo.weather.api.dto.view;

public record WeatherViewDto(
    String city,
    double temperatureCelsius,
    int humidityPercentage
) {
}
