package com.cgi.weatherman.factory;

import com.cgi.weatherman.builder.UserBuilder;
import com.cgi.weatherman.builder.UserDtoBuilder;
import com.cgi.weatherman.dto.RegistrationDto;
import com.cgi.weatherman.dto.UserDto;
import com.cgi.weatherman.model.User;

public class UserFactory {
    public static UserDto createUserDto(User user) {
        UserDtoBuilder userDtoBuilder = new UserDtoBuilder(user.getId(), user.getUsername(),
                user.getName(), user.getSurname());

        user.getPhoneNumber().ifPresent(userDtoBuilder::setPhoneNumber);
        user.getEmail().ifPresent(userDtoBuilder::setEmail);

        return userDtoBuilder.apply();
    }

    public static User createUser(RegistrationDto registrationDto) {
        UserBuilder userBuilder = new UserBuilder(registrationDto.getUsername(), registrationDto.getName(),
                registrationDto.getSurname(), registrationDto.getPassword());

        registrationDto.getPhoneNumber().ifPresent(userBuilder::setPhoneNumber);
        registrationDto.getEmail().ifPresent(userBuilder::setEmail);

        return userBuilder.apply();
    }
}
