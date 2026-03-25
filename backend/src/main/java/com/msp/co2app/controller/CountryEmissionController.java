package com.msp.co2app.controller;

import com.msp.co2app.dto.CountryEmissionRequest;
import com.msp.co2app.model.CountryEmission;
import com.msp.co2app.service.CountryEmissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emissions")
public class CountryEmissionController {

    private final CountryEmissionService countryEmissionService;

    public CountryEmissionController(CountryEmissionService countryEmissionService) {
        this.countryEmissionService = countryEmissionService;
    }

    @GetMapping("/{country}")
    public CountryEmission getEmissionByCountry(@PathVariable String country) {
        return countryEmissionService.getEmissionByCountry(country);
    }

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