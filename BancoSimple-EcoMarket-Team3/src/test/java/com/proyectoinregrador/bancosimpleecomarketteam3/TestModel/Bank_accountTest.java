package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class Bank_accountTest {



    @Test
    void cuandoCreamosUnBank_AccountConDatosDebeMantenerValoresAsignados(){

        Bank_account bank_account = new Bank_account();
        User bank_user = new User();
        bank_user.setId(2L);

        bank_account.setId(1L);
        bank_account.setAccount_number(890);
        bank_account.setBalance(BigDecimal.valueOf(750000));
        bank_account.setBank_User(bank_user);



        assertThat(bank_account)
                .hasFieldOrPropertyWithValue("account_number", 890)
                .hasFieldOrPropertyWithValue("balance", BigDecimal.valueOf(750000))
                .hasFieldOrPropertyWithValue("bank_User", bank_user)
                .hasFieldOrPropertyWithValue("id",1L);
    }
}
