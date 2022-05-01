package com.cgi.weatherman.parsers;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.documentModel.WeatherRepresentation;
import com.cgi.weatherman.documentModel.WeatherApiRepresentation;
import org.springframework.web.reactive.function.client.WebClient;

public class WeatherApiParser implements Parser{
    private WebClient webClient;

    public WeatherApiParser(double lat, double lon) {
        this.webClient = WebClientBuilder
                .getWebClient("http://api.weatherapi.com/v1/current.json" +
                        String.format("?key=40377b1c488e4a21a83190020221304&q=%s,%s&aqi=no", lat, lon));
    }

    public WeatherRepresentation getData() {
        return this.webClient.post().retrieve().bodyToMono(WeatherApiRepresentation.class).share().block();
    }
}
