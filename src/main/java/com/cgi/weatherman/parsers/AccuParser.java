package com.cgi.weatherman.parsers;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.model.AccuWeather;
import com.cgi.weatherman.model.Weather;
import org.springframework.web.reactive.function.client.WebClient;

public class AccuParser {
    static WebClient webClientAccu = WebClientBuilder.getWebClient("https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=59.43&lon=24.73");

    public static Weather getData() {
        return webClientAccu.post().retrieve().bodyToMono(AccuWeather.class).share().block();
    }

}
