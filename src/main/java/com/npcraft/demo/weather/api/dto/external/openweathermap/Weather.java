package com.npcraft.demo.weather.api.dto.external.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weather(
    @JsonProperty("id") int id,
    @JsonProperty("main") String main,
    @JsonProperty("description") String description,
    @JsonProperty("icon") String icon
) {
}
