package com.cgi.weatherman.builder;

import com.cgi.weatherman.dto.WeatherDto;
import com.cgi.weatherman.model.Weather;

public class WeatherBuilder {
    public static Weather buildWeather(WeatherDto weather) {
        return new Weather(weather.getTemperatureCelsius());
    }
}
