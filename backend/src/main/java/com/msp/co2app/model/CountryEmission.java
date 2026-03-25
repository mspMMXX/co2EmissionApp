package com.msp.co2app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country_emission")
public class CountryEmission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String country;

    @Column(nullable = false)
    private Integer year;

    @Column(name = "co2_emission", nullable = false)
    private Double co2Emission;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private AppUser createdBy;

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
