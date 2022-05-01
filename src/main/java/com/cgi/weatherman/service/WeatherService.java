package com.cgi.weatherman.service;

import com.cgi.weatherman.model.WeatherApi;
import com.cgi.weatherman.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<WeatherApi> getWeathers() {
        return weatherRepository.getAllWeathers();
    }

}
