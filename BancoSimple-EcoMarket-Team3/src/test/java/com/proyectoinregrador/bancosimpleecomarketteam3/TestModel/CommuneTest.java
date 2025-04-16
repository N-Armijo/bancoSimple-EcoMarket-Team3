package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommuneTest {

    @Test
    void cuandoCreamosUnaCommuneConDatosDebeMantenerValoresAsignados() {
        Commune commune = new Commune();
        Region region = new Region();
        region.setId(1L);
        region.setName("Región Metropolitana");

        commune.setId(2L);
        commune.setName("La Cisterna");
        commune.setZip_code("7970000");
        commune.setCommune_Region(region);

        assertThat(commune)
                .hasFieldOrPropertyWithValue("id", 2L)
                .hasFieldOrPropertyWithValue("name", "La Cisterna")
                .hasFieldOrPropertyWithValue("zip_code", "7970000")
                .hasFieldOrPropertyWithValue("commune_Region", region);
    }
}
