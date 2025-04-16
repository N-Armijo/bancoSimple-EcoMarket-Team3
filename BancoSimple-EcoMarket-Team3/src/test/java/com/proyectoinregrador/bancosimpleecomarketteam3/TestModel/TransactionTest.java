package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Transaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {

    @Test
    void testTransactionModel() {
        Bank_account originAccount = new Bank_account();
        originAccount.setId(1L);

        Bank_account destinyAccount = new Bank_account();
        destinyAccount.setId(2L);

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setAmount(new BigDecimal("25000.50"));
        transaction.setType("Transferencia");
        transaction.setDate(LocalDate.of(2024, 4, 16));
        transaction.setDescription("Pago de factura");
        transaction.setState("Completado");
        transaction.setTransaction_Origin(originAccount);
        transaction.setTransaction_Destiny(destinyAccount);

        assertThat(transaction.getId()).isEqualTo(1L);
        assertThat(transaction.getAmount()).isEqualTo(new BigDecimal("25000.50"));
        assertThat(transaction.getType()).isEqualTo("Transferencia");
        assertThat(transaction.getDate()).isEqualTo(LocalDate.of(2024, 4, 16));
        assertThat(transaction.getDescription()).isEqualTo("Pago de factura");
        assertThat(transaction.getState()).isEqualTo("Completado");
        assertThat(transaction.getTransaction_Origin()).isEqualTo(originAccount);
        assertThat(transaction.getTransaction_Destiny()).isEqualTo(destinyAccount);
    }
}
