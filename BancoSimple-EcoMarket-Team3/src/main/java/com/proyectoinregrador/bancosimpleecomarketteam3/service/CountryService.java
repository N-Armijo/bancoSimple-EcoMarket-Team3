package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;

import java.util.List;

public interface CountryService{

    Country findById(Long id);
    List<Country> findAllCountry();
    Country saveCountry(Country country);
    void deleteCountryById(Long id);

}
