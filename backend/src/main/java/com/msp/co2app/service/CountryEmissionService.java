package com.msp.co2app.service;

import com.msp.co2app.model.AppUser;
import com.msp.co2app.model.CountryEmission;
import com.msp.co2app.repository.AppUserRepository;
import com.msp.co2app.repository.CountryEmissionRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryEmissionService {

    private final CountryEmissionRepository countryEmissionRepository;
    private final AppUserRepository appUserRepository;

    public CountryEmissionService(CountryEmissionRepository countryEmissionRepository,
                                  AppUserRepository appUserRepository) {
        this.countryEmissionRepository = countryEmissionRepository;
        this.appUserRepository = appUserRepository;
    }

    public CountryEmission getEmissionByCountry(String country) {
        return countryEmissionRepository.findByCountryIgnoreCase(country);
    }

    public CountryEmission saveOrUpdateEmission(String country, Integer year, Double co2Emission, String username) {
        AppUser user = appUserRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        CountryEmission countryEmission = countryEmissionRepository.findByCountryIgnoreCase(country);

        if (countryEmission == null) {
            countryEmission = new CountryEmission();
            countryEmission.setCountry(country);
        }

        countryEmission.setYear(year);
        countryEmission.setCo2Emission(co2Emission);
        countryEmission.setCreatedBy(user);

        return countryEmissionRepository.save(countryEmission);
    }
}