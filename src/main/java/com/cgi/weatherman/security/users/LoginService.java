package com.cgi.weatherman.security.users;

import com.cgi.weatherman.model.User;
import com.cgi.weatherman.repository.UserRepository;
import com.cgi.weatherman.security.ApplicationRoles;
import com.cgi.weatherman.security.jwt.JwtTokenProvider;
import com.cgi.weatherman.service.exceptions.UserBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class LoginService {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {
        if (isBlank(request.getUsername())) {
            throw new UserBadRequestException();
        }

        if (isBlank(request.getPassword())) {
            throw new UserBadRequestException();
        }

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal.getUsername());

        return new LoginResponse(principal.getUsername(), token, getRole(principal));
    }

    public void register(RegisterRequest registerRequest) {
        if (isBlank(registerRequest.getUsername())) {
            throw new UserBadRequestException();
        }

        if (isBlank(registerRequest.getPassword())) {
            throw new UserBadRequestException();
        }

        if (!userRepository.findByUsername(registerRequest.getUsername()).isEmpty()) {
            throw new UserBadRequestException();
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setName(registerRequest.getName());
        user.setSurname(registerRequest.getSurname());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }

    private UserRole getRole(UserDetails principal) {
        boolean isAdmin = principal.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(ApplicationRoles.ADMIN));
        return (isAdmin) ? UserRole.ADMIN : UserRole.USER;
    }
}

