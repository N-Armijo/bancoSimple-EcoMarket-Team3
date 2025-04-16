package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class Order_productTest {

    @Test
    void cuandoCreamosUnOrder_productConDatosDebeMantenerValoresAsignados() {
        Order_product order = new Order_product();

        User user = new User();
        user.setId(2L);

        Bank_account account = new Bank_account();
        account.setId(3L);

        LocalDate fecha = LocalDate.of(2025, 4, 15);

        order.setId(1L);
        order.setDirection_alias("Casa");
        order.setDateP(fecha);
        order.setTotal(12000);
        order.setState("Pendiente");
        order.setOrder_User(user);
        order.setOrder_Account(account);

        assertThat(order)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("direction_alias", "Casa")
                .hasFieldOrPropertyWithValue("dateP", fecha)
                .hasFieldOrPropertyWithValue("total", 12000)
                .hasFieldOrPropertyWithValue("state", "Pendiente")
                .hasFieldOrPropertyWithValue("order_User", user)
                .hasFieldOrPropertyWithValue("order_Account", account);
    }
}
