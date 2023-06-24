package com.app.healthcare.healthcare_app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class PatientControllerTests extends BaseControllerTest {

    @Test
    void getAll() throws Exception {
        mockMvc.perform(
                        get("/api/patients")
                                .header(HttpHeaders.AUTHORIZATION, getUserAuthorizationHeader())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(
                get("/api/patients/1")
                        .header(HttpHeaders.AUTHORIZATION, getUserAuthorizationHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Luka"))
                .andExpect(jsonPath("$.lastName").value("Peric"));
    }

    @Test
    void getByIdNotFound() throws Exception {
        mockMvc.perform(
                get("/api/patients/100")
                        .header(HttpHeaders.AUTHORIZATION, getUserAuthorizationHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllWithoutAuthorization() throws Exception {
        mockMvc.perform(
                        get("/api/patients")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isUnauthorized());
    }
}
