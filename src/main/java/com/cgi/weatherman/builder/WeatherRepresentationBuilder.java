package com.cgi.weatherman.builder;

import com.cgi.weatherman.documentModel.WeatherRepresentation;
import com.cgi.weatherman.dto.WeatherDto;

public class WeatherRepresentationBuilder {
    public static WeatherDto buildWeatherRepresentation(WeatherRepresentation weatherRepresentation) {
        return new WeatherDto(weatherRepresentation.getTemperatureC());
    }
}
