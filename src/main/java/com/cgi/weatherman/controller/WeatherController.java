package com.cgi.weatherman.controller;

import com.cgi.weatherman.builder.WeatherBuilder;
import com.cgi.weatherman.dto.WeatherDto;
import com.cgi.weatherman.parsers.AccuParser;
import com.cgi.weatherman.parsers.WeatherApiParser;
import com.cgi.weatherman.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/weather")
@RestController
public class WeatherController {
    final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public List<WeatherDto> getWeatherBySource(@RequestParam double lat, @RequestParam double lon) {
        return List.of(
                WeatherBuilder.buildWeatherDto(new AccuParser(lat, lon).getData()),
                WeatherBuilder.buildWeatherDto(new WeatherApiParser(lat, lon).getData()));
    }
}
