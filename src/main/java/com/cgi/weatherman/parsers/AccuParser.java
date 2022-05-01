package com.cgi.weatherman.parsers;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.model.AccuWeather;
import com.cgi.weatherman.model.Weather;
import org.springframework.web.reactive.function.client.WebClient;

public class AccuParser implements Parser{
    private WebClient webClientAccu;

    public AccuParser(double lat, double lon) {
        this.webClientAccu = WebClientBuilder
                .getWebClient("https://api.met.no/weatherapi/locationforecast/2.0/complete" +
                        String.format("?lat=%s&lon=%s", lat, lon));
    }

    public Weather getData() {
        return webClientAccu.post().retrieve().bodyToMono(AccuWeather.class).share().block();
    }

}
