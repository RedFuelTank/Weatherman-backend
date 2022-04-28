package com.cgi.weatherman.builder;

import com.cgi.weatherman.dto.WeatherDto;
import com.cgi.weatherman.model.Weather;

public class WeatherBuilder {
    public static WeatherDto buildWeatherDto(Weather weather) {
        return new WeatherDto(weather.getTemperatureC());
    }
}
