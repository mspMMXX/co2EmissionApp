package com.msp.co2app.controller;

import com.msp.co2app.dto.CountryEmissionRequest;
import com.msp.co2app.model.CountryEmission;
import com.msp.co2app.service.CountryEmissionService;
import org.springframework.web.bind.annotation.*;

/**
 * Controller für CO2-Emissionsdaten.
 * 
 * Stellt Endpunkte bereit, um Emissionsdaten abzurufen sowie neue Daten zu speichern
 * oder bestehende zu aktualisieren.
 */
@RestController
@RequestMapping("/emissions")
@CrossOrigin(origins = "http://localhost:5173") // Erlaubt Zugriff vom React-Frontend
public class CountryEmissionController {

    private final CountryEmissionService countryEmissionService;

    /**
     * Konstruktor-Injection des Service-Layers.
     */
    public CountryEmissionController(CountryEmissionService countryEmissionService) {
        this.countryEmissionService = countryEmissionService;
    }

    /**
     * Endpoint zum Abrufen der Emissionsdaten eines bestimmten Landes.
     * 
     * Liefert den aktuell gespeicherten Datensatz für das angegebene Land zurück.
     * Der Zugriff ist öffentlich möglich (kein Login erforderlich).
     */
    @GetMapping("/{country}")
    public CountryEmission getEmissionByCountry(@PathVariable String country) {
        return countryEmissionService.getEmissionByCountry(country);
    }

    /**
     * Endpoint zum Speichern oder Aktualisieren von Emissionsdaten.
     * 
     * - Falls das Land bereits existiert, wird der bestehende Datensatz überschrieben
     * - Falls das Land noch nicht existiert, wird ein neuer Datensatz erstellt
     * 
     * Zusätzlich wird der Benutzer gespeichert, der die Daten erstellt bzw. geändert hat.
     */
    @PostMapping
    public CountryEmission saveOrUpdateEmission(@RequestBody CountryEmissionRequest request) {
        return countryEmissionService.saveOrUpdateEmission(
                request.getCountry(),
                request.getYear(),
                request.getCo2Emission(),
                request.getUsername()
        );
    }
}