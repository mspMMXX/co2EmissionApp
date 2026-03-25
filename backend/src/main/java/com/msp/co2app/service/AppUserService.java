package com.msp.co2app.service;

import com.msp.co2app.model.AppUser;
import com.msp.co2app.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser register(String username, String password) {
        if (appUserRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists.");
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPasswordHash(password);

        return appUserRepository.save(appUser);
    }

    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}