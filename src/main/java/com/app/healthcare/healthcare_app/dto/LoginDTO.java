package com.app.healthcare.healthcare_app.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {
    private final String jwt;

    public LoginDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}