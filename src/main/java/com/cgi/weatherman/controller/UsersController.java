package com.cgi.weatherman.controller;

import com.cgi.weatherman.dto.RegistrationDto;
import com.cgi.weatherman.dto.UserDto;
import com.cgi.weatherman.security.ApplicationRoles;
import com.cgi.weatherman.security.UserUtil;
import com.cgi.weatherman.security.users.LoginRequest;
import com.cgi.weatherman.security.users.LoginResponse;
import com.cgi.weatherman.security.users.LoginService;
import com.cgi.weatherman.security.users.RegisterRequest;
import com.cgi.weatherman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UsersController {
    private final UserService userService;
    private final LoginService loginService;

    @Autowired
    public UsersController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping
    public List<UserDto> getUsers(@RequestParam Optional<String> name) {
        return userService.getAll(name);
    }

    @PostMapping()
    public UserDto register(@RequestBody RegistrationDto registrationDto) {
        return userService.register(registrationDto);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest registerRequest) {
        loginService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/authorizationTest")
    private Object authorizationTest() {
        return UserUtil.getLoggedInUser();
    }

    @Secured(ApplicationRoles.ADMIN)
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

}

