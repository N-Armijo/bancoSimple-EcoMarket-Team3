package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegionTest {

    @Test
    void cuandoCreamosUnaRegionConDatosDebeMantenerLosValoresAsignados() {

        Country country = new Country();
        country.setId(1L);
        country.setIso("CL");
        country.setName("Chile");
        country.setNationality("Chilena");

        Region region = new Region();
        region.setId(2L);
        region.setName("Región Metropolitana");
        region.setRegion_Country(country);

        assertThat(region)
                .hasFieldOrPropertyWithValue("id", 2L)
                .hasFieldOrPropertyWithValue("name", "Región Metropolitana")
                .hasFieldOrPropertyWithValue("region_Country", country);
    }
}
