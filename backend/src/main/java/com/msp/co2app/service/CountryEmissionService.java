package com.msp.co2app.service;

import com.msp.co2app.model.AppUser;
import com.msp.co2app.model.CountryEmission;
import com.msp.co2app.repository.AppUserRepository;
import com.msp.co2app.repository.CountryEmissionRepository;
import org.springframework.stereotype.Service;

/**
 * Service-Klasse für die Geschäftslogik der CO2-Emissionsdaten.
 * 
 * Verantwortlich für:
 * - Abrufen von Emissionsdaten
 * - Speichern und Aktualisieren von Datensätzen
 */
@Service
public class CountryEmissionService {

    private final CountryEmissionRepository countryEmissionRepository;
    private final AppUserRepository appUserRepository;

    /**
     * Konstruktor-Injection der benötigten Repositories.
     */
    public CountryEmissionService(CountryEmissionRepository countryEmissionRepository,
                                  AppUserRepository appUserRepository) {
        this.countryEmissionRepository = countryEmissionRepository;
        this.appUserRepository = appUserRepository;
    }

    /**
     * Liefert den aktuellen Emissionsdatensatz für ein bestimmtes Land.
     * 
     * Die Suche erfolgt ohne Berücksichtigung der Groß-/Kleinschreibung.
     */
    public CountryEmission getEmissionByCountry(String country) {
        return countryEmissionRepository.findByCountryIgnoreCase(country);
    }

    /**
     * Speichert oder aktualisiert Emissionsdaten.
     * 
     * Ablauf:
     * 1. Benutzer wird anhand des Usernames gesucht
     * 2. Falls kein Benutzer existiert → Fehler
     * 3. Prüfen, ob bereits ein Datensatz für das Land existiert
     *    - Falls ja → Datensatz wird überschrieben
     *    - Falls nein → neuer Datensatz wird erstellt
     * 4. Neue Werte (Jahr, Emission) werden gesetzt
     * 5. Benutzer wird als Ersteller/Änderer gespeichert
     */
    public CountryEmission saveOrUpdateEmission(String country, Integer year, Double co2Emission, String username) {
        
        // Benutzer anhand Username laden (wird für FK benötigt)
        AppUser user = appUserRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        // Prüfen, ob bereits ein Datensatz für das Land existiert
        CountryEmission countryEmission = countryEmissionRepository.findByCountryIgnoreCase(country);

        if (countryEmission == null) {
            // Falls kein Datensatz existiert → neuer Eintrag
            countryEmission = new CountryEmission();
            countryEmission.setCountry(country);
        }

        // Setzen bzw. Überschreiben der aktuellen Werte
        countryEmission.setYear(year);
        countryEmission.setCo2Emission(co2Emission);

        // Verknüpfung mit dem Benutzer (FK-Beziehung)
        countryEmission.setCreatedBy(user);

        // Speichern in der Datenbank (Insert oder Update automatisch durch JPA)
        return countryEmissionRepository.save(countryEmission);
    }
}