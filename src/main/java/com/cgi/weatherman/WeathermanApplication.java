package com.cgi.weatherman;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
@OpenAPIDefinition
public class WeathermanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeathermanApplication.class, args);
	}

}
