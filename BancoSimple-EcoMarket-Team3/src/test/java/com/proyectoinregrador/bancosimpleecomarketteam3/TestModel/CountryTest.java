package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryTest {

    @Test
    void cuandoCreamosUnCountryConDatosDebeMantenerValoresAsignados() {
        Country country = new Country();

        country.setId(1L);
        country.setIso("CL");
        country.setName("Chile");
        country.setNationality("Chilena");

        assertThat(country)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("iso", "CL")
                .hasFieldOrPropertyWithValue("name", "Chile")
                .hasFieldOrPropertyWithValue("nationality", "Chilena");
    }
}
