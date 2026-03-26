package com.msp.co2app.controller;

import com.msp.co2app.dto.LoginRequest;
import com.msp.co2app.dto.RegisterRequest;
import com.msp.co2app.model.AppUser;
import com.msp.co2app.service.AppUserService;
import org.springframework.web.bind.annotation.*;

/**
 * Controller für Authentifizierungsfunktionen wie Registrierung und Login.
 * 
 * Stellt REST-Endpunkte bereit, über die Benutzer angelegt und überprüft werden können.
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // Erlaubt Anfragen vom Frontend (CORS)
public class AuthController {

    private final AppUserService appUserService;

    /**
     * Konstruktor-Injection des Service-Layers.
     */
    public AuthController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    /**
     * Endpoint zur Registrierung eines neuen Benutzers.
     * 
     * Nimmt Username und Passwort entgegen und legt einen neuen Benutzer an.
     */
    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterRequest request) {
        return appUserService.register(request.getUsername(), request.getPassword());
    }

    /**
     * Endpoint für den Login.
     * 
     * Prüft, ob ein Benutzer existiert und ob das Passwort korrekt ist.
     * Gibt eine einfache Textantwort zurück.
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        AppUser user = appUserService.findByUsername(request.getUsername());

        // Prüft, ob der Benutzer existiert
        if (user == null) {
            return "User not found.";
        }

        // Vergleich des eingegebenen Passworts mit dem gespeicherten Passwort
        // (in diesem Prototyp ohne Verschlüsselung umgesetzt)
        if (!user.getPasswordHash().equals(request.getPassword())) {
            return "Invalid password.";
        }

        return "Login successful.";
    }
}