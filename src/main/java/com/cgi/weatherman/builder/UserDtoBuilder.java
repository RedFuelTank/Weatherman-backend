package com.cgi.weatherman.builder;

import com.cgi.weatherman.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoBuilder extends ClientBuilder {
    protected Long id;

    public UserDtoBuilder(Long id, String username, String name, String surname) {
        super(username, name, surname);
        this.id = id;
    }

    public UserDto apply() {
        return new UserDto(this.id, this.username, this.email, this.name, this.surname, this.phoneNumber);
    }
}

