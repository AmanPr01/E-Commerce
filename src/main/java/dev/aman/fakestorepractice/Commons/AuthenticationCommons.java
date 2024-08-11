package dev.aman.fakestorepractice.Commons;

import dev.aman.fakestorepractice.DTOs.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO validateToken(String token) {
        // make a call to validate token api from userService to validate token.

        UserDTO userDTO = restTemplate.getForObject(
                "http://localhost:8080/users/validate/" + token,
                UserDTO.class
        );

        return userDTO;
    }
}
