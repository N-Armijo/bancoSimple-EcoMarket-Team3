package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.CountryRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CountryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryServiceImpl countryService;


    @Test
    @DisplayName("retornaCountryAlGuardar")
    public void retornaCountryAlGuardar() {

        Country country = new Country();

        country.setId(1L);
        country.setIso("CL");
        country.setName("Santiago");
        country.setNationality("Chile");

        when(countryRepository.save(country)).thenReturn(country);
        Country cont = countryService.saveCountry(country);

        assertEquals(country.getId(), cont.getId());
        assertEquals(country.getIso(), cont.getIso());
        assertEquals(country.getName(), cont.getName());
        assertEquals(country.getNationality(), cont.getNationality());



    }

}
