package com.cgi.weatherman;

import com.cgi.weatherman.builder.WebClientBuilder;
import com.cgi.weatherman.model.SourceApiKey;
import com.cgi.weatherman.repository.SourceApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationInit implements CommandLineRunner {
    @Autowired
    SourceApiKeyRepository sourceApiKeyRepository;

    @Override
    public void run(String... args) throws Exception {
        WebClient webClient = WebClientBuilder.getWebClient("http://api.weatherapi.com/v1/current.json?key=40377b1c488e4a21a83190020221304&q=London&aqi=no");

        SourceApiKey sourceApiKey = new SourceApiKey("test", "http://api.weatherapi.com/v1/current.json?key=40377b1c488e4a21a83190020221304&q=London&aqi=no");
        SourceApiKey sourceApiKey1 = new SourceApiKey("test1", "HRw2sGdd4lT0CU7y8JHTHLFLPjBfTFg4");

        List<SourceApiKey> keyApiList = new ArrayList<>(Arrays.asList(sourceApiKey1, sourceApiKey));
        sourceApiKeyRepository.saveAll(keyApiList);
    }
}
