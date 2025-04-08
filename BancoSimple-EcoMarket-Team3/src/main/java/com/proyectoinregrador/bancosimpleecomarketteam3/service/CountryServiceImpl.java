package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    @Override
    public Country findById(Long id) {
        return null;
    }

    @Override
    public List<Country> findAllCountry() {
        return List.of();
    }

    @Override
    public Country saveCountry(Country country) {
        return null;
    }

    @Override
    public void deleteCountryById(Long id) {

    }
}
