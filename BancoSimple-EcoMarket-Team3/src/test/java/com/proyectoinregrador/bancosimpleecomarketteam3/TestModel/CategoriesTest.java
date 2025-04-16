package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest {

    @Test
    void cuandoCreamosUnaCategoriaConDatosDebeMantenerValoresAsignados() {
        Categories categoria = new Categories();

        categoria.setId(1L);
        categoria.setNombre("Alimentos");
        categoria.setDescription("Productos comestibles y bebidas");

        assertThat(categoria)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("nombre", "Alimentos")
                .hasFieldOrPropertyWithValue("description", "Productos comestibles y bebidas");
    }
}
