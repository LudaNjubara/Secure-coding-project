package com.app.healthcare.healthcare_app.controller;

import com.app.healthcare.healthcare_app.dto.LoginDTO;
import com.app.healthcare.healthcare_app.model.Provider;
import com.app.healthcare.healthcare_app.request.LoginRequest;
import com.app.healthcare.healthcare_app.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/xss")
    public String executeXSS(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "xss";
    }

    @RequestMapping(value = "/csrf", method = {RequestMethod.GET, RequestMethod.POST})
    public String executeCSRF(@ModelAttribute Provider formModel, Model model) {
        model.addAttribute("formModel", formModel);
        return "csrf";
    }

    @RequestMapping(value = "/bac", method = {RequestMethod.GET, RequestMethod.POST})
    public String executeBAC(@RequestParam(name = "bac", required = false) String filePath, Model model) {
        // from resources folder and filePath load file contents
        if (filePath != null) {
            try {
//                if (filePath.contains("..")) {
//                    model.addAttribute("errorMessage", "Invalid file path");
//                    model.addAttribute("fileContents", "");
//                    return "bac";
//                }
                String fileContents = new String(Files.readAllBytes(Paths.get("src/main/resources/static/" + filePath)));
                model.addAttribute("fileContents", fileContents);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "bac";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String executeLogin(@RequestParam(name = "username", required = false) String username,
                               @RequestParam(name = "password", required = false) String password,
                               Model model) {
        if (username != null && password != null) {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUsername(username);
            loginRequest.setPassword(password);

            Optional<LoginDTO> loginDTO = authenticationService.login(loginRequest);

            if (loginDTO.isPresent()) {
                model.addAttribute("token", loginDTO.get().getJwt());
            } else {
                model.addAttribute("errorMessage", "Invalid username or password");
            }
            return "login";
        }

        return "login";
    }
}