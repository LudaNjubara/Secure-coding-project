package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.JwtUser;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(JwtUser jwtUser);
}
