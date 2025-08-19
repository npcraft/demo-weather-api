package com.npcraft.demo.weather.api.service;

import com.npcraft.demo.weather.api.dto.external.openweathermap.WeatherResponse;
import com.npcraft.demo.weather.api.dto.view.WeatherViewDto;
import com.npcraft.demo.weather.api.exception.CityNotFoundException;
import com.npcraft.demo.weather.api.mapper.WeatherMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Log4j2
public class WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherMapper weatherMapper;
    @Value("${weather.api.url}")
    private String weatherApiUrl;

    public WeatherService(WeatherMapper weatherMapper, RestTemplate restTemplate) {
        this.weatherMapper = weatherMapper;
        this.restTemplate = restTemplate;
    }

    public WeatherViewDto getWeatherForCity(String city, String apiKey) {
        String url = UriComponentsBuilder.fromUriString(weatherApiUrl)
            .queryParam("q", city)
            .queryParam("appid", apiKey)
            .queryParam("units", "metric")
            .toUriString();

        try {
            WeatherResponse externalResponse = restTemplate.getForObject(url, WeatherResponse.class);
            return weatherMapper.toWeatherViewDto(externalResponse);
        } catch (HttpClientErrorException.NotFound ex) {
            log.warn("External weather API returned 404 for city '{}'. Response: {}", city, ex.getResponseBodyAsString());
            throw new CityNotFoundException("City not found on the external weather service: " + city);
        }
    }
}
