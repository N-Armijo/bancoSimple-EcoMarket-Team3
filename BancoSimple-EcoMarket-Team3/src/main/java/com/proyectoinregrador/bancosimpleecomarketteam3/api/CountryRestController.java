package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryRestController {

    private final CountryServiceImpl countryService;

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Country>> findAllCountries() {
        return ResponseEntity.ok(countryService.findAllCountry());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Country> saveCountry(@RequestBody Country newCountry) {
        return new ResponseEntity<>(countryService.saveCountry(newCountry), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountryById(id);
        return new ResponseEntity<>("The country was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country editedCountry) {
        Country selectedCountry = countryService.findById(id);
        selectedCountry.setIso(editedCountry.getIso());
        selectedCountry.setName(editedCountry.getName());
        selectedCountry.setNationality(editedCountry.getNationality());
        return new ResponseEntity<>(countryService.saveCountry(selectedCountry), HttpStatus.OK);
    }
}
