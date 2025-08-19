package com.npcraft.demo.weather.api.dto.external.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Coord(
    @JsonProperty("lon") double lon,
    @JsonProperty("lat") double lat
) {
}
