package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Be_pass;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Be_passRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Be_passServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Be_passServiceTest {


    @Mock
    private Be_passRepository be_passRepository;

    @InjectMocks
    private Be_passServiceImpl be_passService;


    @Test
    @DisplayName("retornaBe_passAlGuardar")
    void retornaBe_passAlGuardar(){

        Be_pass be_pass = new Be_pass();
        Bank_account bank_account = new Bank_account();

        be_pass.setId(1L);
        be_pass.setPassword("password");
        be_pass.setPass_Account(bank_account);


        when(be_passRepository.save(be_pass)).thenReturn(be_pass);

        Be_pass bePass = be_passService.saveBe_pass(be_pass);

        assertEquals(be_pass.getId(), bePass.getId());
        assertEquals(be_pass.getPassword(), bePass.getPassword());
        assertEquals(be_pass.getPass_Account().getId(), bePass.getPass_Account().getId());



    }


}
