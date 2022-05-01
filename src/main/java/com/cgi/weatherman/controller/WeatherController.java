package com.cgi.weatherman.controller;

import com.cgi.weatherman.builder.WeatherRepresentationBuilder;
import com.cgi.weatherman.dto.WeatherDto;
import com.cgi.weatherman.parsers.AccuParser;
import com.cgi.weatherman.parsers.WeatherApiParser;
import com.cgi.weatherman.service.WeatherComparisonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/weather")
@RestController
public class WeatherController {
    final WeatherComparisonService weatherComparisonService;

    public WeatherController(WeatherComparisonService weatherComparisonService) {
        this.weatherComparisonService = weatherComparisonService;
    }

    @GetMapping()
    public List<WeatherDto> getWeatherBySource(@RequestParam double lat, @RequestParam double lon) {
        return List.of(
                WeatherRepresentationBuilder.buildWeatherRepresentation(new AccuParser(lat, lon).getData()),
                WeatherRepresentationBuilder.buildWeatherRepresentation(new WeatherApiParser(lat, lon).getData()));
    }


}
