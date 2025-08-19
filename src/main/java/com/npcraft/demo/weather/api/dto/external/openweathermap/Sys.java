package com.npcraft.demo.weather.api.dto.external.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Sys(
    @JsonProperty("type") int type,
    @JsonProperty("id") int id,
    @JsonProperty("country") String country,
    @JsonProperty("sunrise") long sunrise,
    @JsonProperty("sunset") long sunset
) {
}
