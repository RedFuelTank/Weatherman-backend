package com.cgi.weatherman.controller;

import com.cgi.weatherman.model.WeatherWrapper;
import com.cgi.weatherman.service.WeatherComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static com.cgi.weatherman.security.ApplicationRoles.USER;

@RequestMapping("/comparison")
@RestController
public class ComparisonController {

    @Autowired
    WeatherComparisonService weatherComparisonService;

    @GetMapping()
    public void getComparisonsByUser() {}

    @PostMapping()
    @Secured(USER)
    public void saveComparison(@RequestHeader("Authorization") String authorToken, @RequestBody WeatherWrapper wrapper) {
        System.out.println(authorToken);
        System.out.println(wrapper.getSeries());

        weatherComparisonService.save(wrapper.getSeries(), authorToken.substring(7));
    }
}
