package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_card;

import java.util.List;

public interface Bank_cardService{

    Bank_card findById(Long id);
    List<Bank_card> findAllBank_card();
    Bank_card saveBank_card(Bank_card bank_card);
    void deleteBank_cardById(Long id);

}
