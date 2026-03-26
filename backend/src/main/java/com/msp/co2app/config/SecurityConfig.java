package com.msp.co2app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Konfigurationsklasse für die Sicherheit der Anwendung.
 * 
 * In diesem Prototyp wird die Security bewusst vereinfacht,
 * sodass alle Endpunkte frei zugänglich sind.
 * Dies dient dazu, die Funktionalität der Anwendung ohne
 * zusätzliche Authentifizierung testen zu können.
 */
@Configuration
public class SecurityConfig {

    /**
     * Definiert die Sicherheitsregeln für HTTP-Anfragen.
     * 
     * CSRF-Schutz wird deaktiviert, da es sich um eine einfache REST-API handelt
     * Alle Requests werden erlaubt (kein Login-Zwang auf Framework-Ebene)
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deaktiviert CSRF-Schutz (für einfache API-Kommunikation sinnvoll)
                .csrf(csrf -> csrf.disable())

                // Erlaubt alle Anfragen ohne Authentifizierung
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}