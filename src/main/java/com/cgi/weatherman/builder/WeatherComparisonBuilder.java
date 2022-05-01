package com.cgi.weatherman.builder;

import com.cgi.weatherman.dto.WeatherDto;
import com.cgi.weatherman.model.Weather;
import com.cgi.weatherman.model.WeatherComparison;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherComparisonBuilder {
    public static WeatherComparison buildWeatherComparison(List<WeatherDto> weatherDtos, Long userId) {
        WeatherComparison model = new WeatherComparison();
        List<Weather> weathers = weatherDtos.stream().map(WeatherBuilder::buildWeather).collect(Collectors.toList());
        model.setWeathers(weathers);
        model.setId(userId);

        return model;
    }
}
