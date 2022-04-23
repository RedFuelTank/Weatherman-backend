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
    @Autowired
    WeatherService weatherService;

    @GetMapping("{sourceId}")
    public void getWeatherBySource(@PathVariable int sourceId, @RequestParam double lat, @RequestParam double lon) {
//        WebClient webClient = WebClientBuilder.getWebClient("http://api.weatherapi.com/v1" +
//                "/current.json" +
//                "?key=40377b1c488e4a21a83190020221304");

        WebClient webClient = WebClientBuilder.getWebClient("http://api.weatherapi.com/v1/current.json?key=40377b1c488e4a21a83190020221304&q=London&aqi=no");

        Weather test = webClient.post().retrieve().bodyToMono(Weather.class).share().block();
        System.out.println(test.getCurrent());
    }
}
