package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RolTest {

    @Test
    void cuandoCreamosUnRolConDatosDebeMantenerLosValoresAsignados() {
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setName(ERol.VENDEDOR);
        rol.setDescription("Usuario con permiso para vender productos");

        assertThat(rol)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", ERol.VENDEDOR)
                .hasFieldOrPropertyWithValue("description", "Usuario con permiso para vender productos");
    }
}
