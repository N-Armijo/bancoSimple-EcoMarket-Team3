package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;

import java.util.List;
public interface Bank_accountService{

    Bank_account findById(Long id);
    List<Bank_account> findAllBank_account();
    Bank_account saveBank_account(Bank_account bank_account);
    void deleteBank_accountById(Long id);
}
