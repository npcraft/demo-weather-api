package com.npcraft.demo.weather.api.mapper;

import com.npcraft.demo.weather.api.dto.external.openweathermap.WeatherResponse;
import com.npcraft.demo.weather.api.dto.view.WeatherViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    @Mapping(source = "name", target = "city")
    @Mapping(source = "main.temp", target = "temperatureCelsius")
    @Mapping(source = "main.humidity", target = "humidityPercentage")
    WeatherViewDto toWeatherViewDto(WeatherResponse externalResponse);
}



