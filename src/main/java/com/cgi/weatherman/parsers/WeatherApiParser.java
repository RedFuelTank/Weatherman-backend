package com.cgi.weatherman.parsers;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.model.Weather;
import com.cgi.weatherman.model.WeatherApi;
import org.springframework.web.reactive.function.client.WebClient;

public class WeatherApiParser {
    static WebClient webClient = WebClientBuilder.getWebClient("http://api.weatherapi.com/v1/current.json?key=40377b1c488e4a21a83190020221304&q=Tallinn&aqi=no");

    public static Weather getData() {
        return webClient.post().retrieve().bodyToMono(WeatherApi.class).share().block();
    }
}
