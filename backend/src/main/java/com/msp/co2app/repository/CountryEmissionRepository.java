package com.msp.co2app.repository;

import com.msp.co2app.model.CountryEmission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository für den Zugriff auf CO2-Emissionsdaten.
 * 
 * Erbt von JpaRepository und stellt automatisch Standardoperationen
 * wie Speichern, Finden und Löschen bereit.
 */
public interface CountryEmissionRepository extends JpaRepository<CountryEmission, Integer> {

    /**
     * Sucht Emissionsdaten anhand des Ländernamens (ohne Berücksichtigung der Groß-/Kleinschreibung).
     * 
     * Wird verwendet, um den aktuellen Datensatz eines Landes abzurufen.
     */
    CountryEmission findByCountryIgnoreCase(String country);

    /**
     * Prüft, ob für ein bestimmtes Land bereits ein Datensatz existiert
     * (ebenfalls case-insensitive).
     * 
     * Wichtig für die Logik: entscheiden zwischen "neu anlegen" oder "überschreiben".
     */
    boolean existsByCountryIgnoreCase(String country);
}