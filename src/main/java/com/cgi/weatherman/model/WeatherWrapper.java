package com.cgi.weatherman.model;

import com.cgi.weatherman.dto.WeatherDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherWrapper {
    List<WeatherDto> series;
}
