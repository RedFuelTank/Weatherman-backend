package com.cgi.weatherman.controller;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.service.WeatherService;
import com.cgi.weatherman.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RequestMapping("/weather")
@RestController
public class WeatherController {
    final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("{sourceId}")
    public void getWeatherBySource(@PathVariable int sourceId, @RequestParam double lat, @RequestParam double lon) {
    }
}
