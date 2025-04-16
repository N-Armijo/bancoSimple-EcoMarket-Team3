package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_card;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Bank_cardRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Bank_cardServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Bank_cardServiceTest {

    @Mock
    private Bank_cardRepository bank_cardRepository;

    @InjectMocks
    private Bank_cardServiceImpl bank_cardService;

    @Test
    @DisplayName("retornaank_cardAlGuardar")
    void retornaank_cardAlGuardar(){

        Bank_card bank_card = new Bank_card();
        Bank_account bank_account = new Bank_account();

        bank_card.setId(1L);
        bank_card.setCard_number(1231232);
        bank_card.setExpiration_date(LocalDate.now().plusYears(10));
        bank_card.setCreation_date(LocalDate.now());
        bank_card.setSecret_number(1231232);
        bank_card.setCard_Account(bank_account);

        when(bank_cardRepository.save(bank_card)).thenReturn(bank_card);

        Bank_card card = bank_cardService.saveBank_card(bank_card);

        assertEquals(bank_card.getId(), card.getId());
        assertEquals(bank_card.getCard_number(), card.getCard_number());
        assertEquals(bank_card.getExpiration_date(), card.getExpiration_date());
        assertEquals(bank_card.getSecret_number(), card.getSecret_number());
        assertEquals(bank_card.getCard_Account(), card.getCard_Account());



    }


}
