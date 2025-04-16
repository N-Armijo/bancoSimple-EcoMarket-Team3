package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Be_pass;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Be_passTest {

    @Test
    void cuandoCreamosUnBe_passConDatosDebeMantenerValoresAsignados() {
        Be_pass bePass = new Be_pass();
        Bank_account bankAccount = new Bank_account();
        bankAccount.setId(1L);

        bePass.setId(1L);
        bePass.setPassword("abc123");
        bePass.setPass_Account(bankAccount);

        assertThat(bePass)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("password", "abc123")
                .hasFieldOrPropertyWithValue("pass_Account", bankAccount);
    }
}

