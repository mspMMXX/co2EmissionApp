package com.msp.co2app.model;

import jakarta.persistence.*;

/**
 * Entity-Klasse für CO2-Emissionsdaten eines Landes.
 * 
 * Speichert pro Land genau einen aktuellen Datensatz (kein Verlauf),
 * der bei neuen Eingaben überschrieben wird.
 */
@Entity
@Table(name = "country_emission") // Zuordnung zur Datenbanktabelle
public class CountryEmission {
    
    // Primärschlüssel (automatisch generiert)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Name des Landes (eindeutig, da nur ein Datensatz pro Land existiert)
    @Column(nullable = false, unique = true)
    private String country;

    // Jahr der Emissionsmessung
    @Column(nullable = false)
    private Integer year;

    // CO2-Emissionswert (z. B. in Kilotonnen)
    @Column(name = "co2_emission", nullable = false)
    private Double co2Emission;

    // Referenz auf den Benutzer, der den Datensatz erstellt oder zuletzt geändert hat
    // Many-to-One: Ein Benutzer kann mehrere Datensätze erstellen
    @ManyToOne
    @JoinColumn(name = "created_by")
    private AppUser createdBy;

    // Standardkonstruktor (erforderlich für JPA)
    public CountryEmission() {

    }

    //GETTER AND SETTER
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setCo2Emission(Double co2Emission) {
        this.co2Emission = co2Emission;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public Integer getYear() {
        return year;
    }

    public Double getCo2Emission() {
        return co2Emission;
    }

    public AppUser getCreatedBy() {
        return createdBy;
    }
}