package com.cgi.weatherman.parsers;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.documentModel.AccuWeatherRepresentation;
import com.cgi.weatherman.documentModel.WeatherRepresentation;
import org.springframework.web.reactive.function.client.WebClient;

public class AccuParser implements Parser{
    private WebClient webClientAccu;

    public AccuParser(double lat, double lon) {
        this.webClientAccu = WebClientBuilder
                .getWebClient("https://api.met.no/weatherapi/locationforecast/2.0/complete" +
                        String.format("?lat=%s&lon=%s", lat, lon));
    }

    public WeatherRepresentation getData() {
        return webClientAccu.post().retrieve().bodyToMono(AccuWeatherRepresentation.class).share().block();
    }

}
