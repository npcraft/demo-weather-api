package com.npcraft.demo.weather.api.dto.external.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Clouds(
    @JsonProperty("all") int all
) {
}
