package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;

import java.util.List;
public interface Bank_accountService{

    Bank_account findById(Long id);
    Bank_account findByEmail(String email);
    List<Bank_account> findAllBank_account();
    Bank_account saveBank_account(Bank_account bank_account);
    void deleteBank_accountById(Long id);
}
