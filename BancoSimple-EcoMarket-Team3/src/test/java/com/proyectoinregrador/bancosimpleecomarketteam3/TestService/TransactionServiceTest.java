package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.*;

import com.proyectoinregrador.bancosimpleecomarketteam3.repository.TransactionRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.TransactionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    @DisplayName("retornaTransactionAlGuardar")
    void retornaTransactionAlGuardar(){

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setAmount(BigDecimal.valueOf(500000));
        transaction.setType("Credito");
        transaction.setDate(LocalDate.now());
        transaction.setDescription("Transferencia por lo acordado");
        transaction.setState("Pendiente");

        Transaction transaction2 = new Transaction();
        transaction2.setId(1L);
        transaction2.setAmount(BigDecimal.valueOf(500000));
        
        when(transactionRepository.findById(1L)).thenReturn(transaction2);
        
        Transaction result = transactionRepository.findById(1L);

        assertEquals(transaction.getId(), result.getId());
        assertEquals(transaction.getAmount(), result.getAmount());

        System.out.println(transaction);
        System.out.println(transaction2);
        
        
    }
}
