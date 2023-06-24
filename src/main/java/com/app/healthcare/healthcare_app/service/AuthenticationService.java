package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.dto.LoginDTO;
import com.app.healthcare.healthcare_app.request.LoginRequest;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginRequest req);

}