package com.cgi.weatherman.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto extends ClientDto {
    private String password;

    public RegistrationDto(String username, String password, String email, String name, String surname, String phoneNumber) {
        super(username, email, name, surname, phoneNumber);
        this.password = password;
    }
}

