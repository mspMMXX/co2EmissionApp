package com.msp.co2app.model;

import jakarta.persistence.*;

/**
 * Entity-Klasse für Benutzer der Anwendung.
 * 
 * Repräsentiert einen registrierten Nutzer, der Emissionsdaten
 * hinzufügen oder ändern kann.
 */
@Entity
@Table(name = "app_user") // Zuordnung zur Datenbanktabelle "app_user"
public class AppUser {

    // Primärschlüssel (automatisch generiert)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Benutzername (muss eindeutig und darf nicht null sein)
    @Column(nullable = false, unique = true)
    private String username;

    // Passwort (hier als einfacher String gespeichert, ohne Verschlüsselung im Prototyp)
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    // Standardkonstruktor (erforderlich für JPA)
    public AppUser() {
        
    }

    //GETTER AND SETTER
    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}