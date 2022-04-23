package com.cgi.weatherman.controller;

import com.cgi.weatherman.model.SourceApiKey;
import com.cgi.weatherman.service.SourceApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/keys")
@RestController
public class SourceKeyController {

    final SourceApiService sourceApiService;

    public SourceKeyController(SourceApiService sourceApiService) {
        this.sourceApiService = sourceApiService;
    }

    @GetMapping("/")
    public SourceApiKey getKey() {
        return sourceApiService.getSourceApiKeys().get(0);
    }
}
