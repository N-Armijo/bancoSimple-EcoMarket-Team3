package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Direction;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void cuandoCreamosUnaDirectionConDatosDebeMantenerValoresAsignados() {
        Direction direction = new Direction();

        User user = new User();
        user.setId(2L);

        Commune commune = new Commune();
        commune.setId(3L);

        LocalDate fechaCreacion = LocalDate.of(2025, 4, 15);

        direction.setId(1L);
        direction.setAlias("Casa");
        direction.setStreet("Av. Los Libertadores");
        direction.setNumber(742);
        direction.setDepartment("1301");
        direction.setHome(true);
        direction.setCreation_date(fechaCreacion);
        direction.setDirection_User(user);
        direction.setDirection_Commune(commune);

        assertThat(direction)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("alias", "Casa")
                .hasFieldOrPropertyWithValue("street", "Av. Los Libertadores")
                .hasFieldOrPropertyWithValue("number", 742)
                .hasFieldOrPropertyWithValue("department", "1301")
                .hasFieldOrPropertyWithValue("home", true)
                .hasFieldOrPropertyWithValue("creation_date", fechaCreacion)
                .hasFieldOrPropertyWithValue("direction_User", user)
                .hasFieldOrPropertyWithValue("direction_Commune", commune);
    }
}
