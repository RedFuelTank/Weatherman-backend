package com.cgi.weatherman.service;

import com.cgi.weatherman.builder.WeatherComparisonBuilder;
import com.cgi.weatherman.documentModel.WeatherApiRepresentation;
import com.cgi.weatherman.dto.WeatherDto;
import com.cgi.weatherman.model.Weather;
import com.cgi.weatherman.model.WeatherComparison;
import com.cgi.weatherman.repository.UserRepository;
import com.cgi.weatherman.repository.WeatherComparisonRepository;
import com.cgi.weatherman.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherComparisonService {
    final WeatherComparisonRepository weatherComparisonRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;


    public WeatherComparisonService(WeatherComparisonRepository weatherComparisonRepository) {
        this.weatherComparisonRepository = weatherComparisonRepository;
    }

    public List<WeatherApiRepresentation> getWeathers() {
        return weatherComparisonRepository.getAllWeathers();
    }

    public void save(List<WeatherDto> weatherDtos, String token) {
        String userUsername = tokenProvider.getUsernameFromToken(token);

        WeatherComparison weatherComparison = WeatherComparisonBuilder
                .buildWeatherComparison(weatherDtos, userRepository.findByUsername(userUsername).get(0).getId());

        weatherComparisonRepository.save(weatherComparison);
    }

}
