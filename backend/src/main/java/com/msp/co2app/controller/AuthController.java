package com.msp.co2app.controller;

import com.msp.co2app.dto.LoginRequest;
import com.msp.co2app.dto.RegisterRequest;
import com.msp.co2app.model.AppUser;
import com.msp.co2app.service.AppUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService appUserService;

    public AuthController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterRequest request) {
        return appUserService.register(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        AppUser user = appUserService.findByUsername(request.getUsername());

        if (user == null) {
            return "User not found.";
        }

        if (!user.getPasswordHash().equals(request.getPassword())) {
            return "Invalid password.";
        }

        return "Login successful.";
    }
}