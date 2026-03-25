package com.msp.co2app.repository;

import com.msp.co2app.model.CountryEmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryEmissionRepository extends JpaRepository<CountryEmission, Integer> {

    CountryEmission findByCountryIgnoreCase(String country);

    boolean existsByCountryIgnoreCase(String country);
}