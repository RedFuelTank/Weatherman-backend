package com.cgi.weatherman.service;

import com.cgi.weatherman.model.SourceApiKey;
import com.cgi.weatherman.model.Weather;
import com.cgi.weatherman.repository.SourceApiKeyRepository;
import com.cgi.weatherman.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    final WeatherRepository weatherRepository;
    final SourceApiKeyRepository sourceApiKeyRepository;

    public WeatherService(WeatherRepository weatherRepository, SourceApiKeyRepository sourceApiKeyRepository) {
        this.weatherRepository = weatherRepository;
        this.sourceApiKeyRepository = sourceApiKeyRepository;
    }

    public List<Weather> getWeathers() {
        return weatherRepository.getAllWeathers();
    }

    public List<SourceApiKey> getKeys() {
        return sourceApiKeyRepository.getAllSourceApiKeys();
    }
}
