package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Desc_ticketTest {

    @Test
    void cuandoCreamosUnDesc_ticketConDatosDebeMantenerValoresAsignados() {
        Desc_ticket descTicket = new Desc_ticket();

        descTicket.setId(1L);
        descTicket.setName("Descuento Eco");
        descTicket.setDescription("Descuento por compras ecológicas");
        descTicket.setTable_reference("eco_discount_table");

        assertThat(descTicket)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", "Descuento Eco")
                .hasFieldOrPropertyWithValue("description", "Descuento por compras ecológicas")
                .hasFieldOrPropertyWithValue("table_reference", "eco_discount_table");
    }
}
