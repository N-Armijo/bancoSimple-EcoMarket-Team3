package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Bank_accountRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Bank_accountService;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Bank_accountServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Bank_accountServiceTest {


    @Mock
    private Bank_accountRepository bank_accountRepository;

    @InjectMocks
    private Bank_accountServiceImpl bank_accountService;

    @Test
    @DisplayName("retornaBank_accountBank_accountAlGuardar")
    void retornaBank_accountBank_accountAlGuardar(){


        Bank_account bank_account = new Bank_account();
        User bank_user = new User();
        bank_user.setId(1L);

        bank_account.setId(1L);
        bank_account.setAccount_number(123123);
        bank_account.setBalance(BigDecimal.valueOf(123333.00));
        bank_account.setBank_User(bank_user);

        when(bank_accountRepository.save(bank_account)).thenReturn(bank_account);
        Bank_account bank_account2 = bank_accountService.saveBank_account(bank_account);

        assertEquals(bank_account.getId(), bank_account2.getId());
        assertEquals(bank_account.getAccount_number(), bank_account2.getAccount_number());
        assertEquals(bank_account.getBalance(), bank_account2.getBalance());
        assertEquals(bank_account.getBank_User().getId(), bank_account2.getBank_User().getId());

    }
}
