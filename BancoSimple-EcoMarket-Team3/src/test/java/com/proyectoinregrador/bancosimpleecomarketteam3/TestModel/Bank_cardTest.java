package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_card;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class Bank_cardTest {

    @Test
    void cuandoCreamosUnaBank_CardConDatosDebeMantenerValoresAsignados() {
        Bank_card bankCard = new Bank_card();
        Bank_account bankAccount = new Bank_account();
        bankAccount.setId(1L);

        bankCard.setId(2L);
        bankCard.setCard_number(12345678);
        bankCard.setCreation_date(LocalDate.of(2024, 1, 1));
        bankCard.setExpiration_date(LocalDate.of(2026, 1, 1));
        bankCard.setSecret_number(999);
        bankCard.setCard_Account(bankAccount);

        assertThat(bankCard)
                .hasFieldOrPropertyWithValue("id", 2L)
                .hasFieldOrPropertyWithValue("card_number", 12345678)
                .hasFieldOrPropertyWithValue("creation_date", LocalDate.of(2024, 1, 1))
                .hasFieldOrPropertyWithValue("expiration_date", LocalDate.of(2026, 1, 1))
                .hasFieldOrPropertyWithValue("secret_number", 999)
                .hasFieldOrPropertyWithValue("card_Account", bankAccount);
    }
}

