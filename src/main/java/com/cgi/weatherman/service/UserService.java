package com.cgi.weatherman.service;

import com.cgi.weatherman.dto.RegistrationDto;
import com.cgi.weatherman.dto.UserDto;
import com.cgi.weatherman.factory.UserFactory;
import com.cgi.weatherman.model.User;
import com.cgi.weatherman.repository.UserRepository;
import com.cgi.weatherman.service.exceptions.BadNameException;
import com.cgi.weatherman.service.exceptions.BadSurnameException;
import com.cgi.weatherman.service.exceptions.BadUsernameException;
import com.cgi.weatherman.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAll(@RequestParam Optional<String> nameOp) {
        if (nameOp.isEmpty()) {
            return convertToDto(userRepository.findAll());
        } else {
            return convertToDto(userRepository.findByNameIsLike('%' + nameOp.get().toLowerCase() + '%'));
        }
    }

    private List<UserDto> convertToDto(List<User> users) {
        return users.stream()
                .map(UserFactory::createUserDto)
                .collect(Collectors.toList());

    }

    public UserDto register(RegistrationDto registrationDto) {
        if (registrationDto.getUsername().isBlank()) {
            throw new BadUsernameException();
        }

        if (registrationDto.getName().isBlank()) {
            throw new BadNameException();
        }

        if (registrationDto.getSurname().isBlank()) {
            throw new BadSurnameException();
        }

        User savedUser = userRepository.save(UserFactory.createUser(registrationDto));
        return findById(savedUser.getId());
    }

    public UserDto findById(Long id) {
        User user = getDbUserByID(id);
        return UserFactory.createUserDto(user);
    }

    private User getDbUserByID(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
