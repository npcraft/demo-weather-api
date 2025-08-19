package com.npcraft.demo.weather.api.dto.external.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Main(
    @JsonProperty("temp") double temp,
    @JsonProperty("feels_like") double feelsLike,
    @JsonProperty("temp_min") double tempMin,
    @JsonProperty("temp_max") double tempMax,
    @JsonProperty("pressure") int pressure,
    @JsonProperty("humidity") int humidity,
    @JsonProperty("sea_level") int seaLevel,
    @JsonProperty("grnd_level") int grndLevel
) {
}
