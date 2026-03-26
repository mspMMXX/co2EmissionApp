package com.msp.co2app.service;

import com.msp.co2app.model.AppUser;
import com.msp.co2app.repository.AppUserRepository;
import org.springframework.stereotype.Service;

/**
 * Service-Klasse für Benutzerlogik.
 * 
 * Enthält die Geschäftslogik rund um Registrierung und das Abrufen von Benutzern.
 * Greift dabei auf das Repository für den Datenbankzugriff zurück.
 */
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    /**
     * Konstruktor-Injection des Repository-Layers.
     */
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /**
     * Registriert einen neuen Benutzer.
     * 
     * - Prüft, ob der Username bereits existiert
     * - Falls nicht, wird ein neuer Benutzer erstellt und gespeichert
     */
    public AppUser register(String username, String password) {
        // Verhindert doppelte Benutzernamen
        if (appUserRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists.");
        }

        // Erstellung eines neuen Benutzers
        AppUser appUser = new AppUser();
        appUser.setUsername(username);

        // Im Prototyp wird das Passwort direkt gespeichert (ohne Hashing)
        appUser.setPasswordHash(password);

        // Speichert den Benutzer in der Datenbank
        return appUserRepository.save(appUser);
    }

    /**
     * Sucht einen Benutzer anhand seines Usernames.
     */
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}