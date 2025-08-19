package com.npcraft.demo.weather.api.dto.external.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(
    @JsonProperty("coord") Coord coord,
    @JsonProperty("weather") List<Weather> weather,
    @JsonProperty("base") String base,
    @JsonProperty("main") Main main,
    @JsonProperty("visibility") int visibility,
    @JsonProperty("wind") Wind wind,
    @JsonProperty("clouds") Clouds clouds,
    @JsonProperty("dt") long dt,
    @JsonProperty("sys") Sys sys,
    @JsonProperty("timezone") int timezone,
    @JsonProperty("id") int id,
    @JsonProperty("name") String name,
    @JsonProperty("cod") int cod
) {
}
