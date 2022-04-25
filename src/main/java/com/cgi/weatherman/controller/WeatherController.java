package com.cgi.weatherman.controller;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.model.AccuWeather;
import com.cgi.weatherman.model.WeatherApi;
import com.cgi.weatherman.service.WeatherService;
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

//        WebClient webClient = WebClientBuilder.getWebClient("https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=59.43&lon=24.73");
        WebClient webClientAccu = WebClientBuilder.getWebClient("https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=59.43&lon=24.73");

//        WeatherApi test = webClient.post().retrieve().bodyToMono(WeatherApi.class).share().block();
        AccuWeather testAccu = webClientAccu.post().retrieve().bodyToMono(AccuWeather.class).share().block();

//        System.out.println(test.getTemperatureC());
        System.out.println(testAccu.getTemperatureC());
    }
}
