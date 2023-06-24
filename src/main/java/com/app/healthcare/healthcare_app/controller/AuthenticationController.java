package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.dto.LoginDTO;
import com.app.healthcare.healthcare_app.request.LoginRequest;
import com.app.healthcare.healthcare_app.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public LoginDTO login(@Valid @RequestBody final LoginRequest req) {
        return authenticationService.login(req)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials"));
    }
}