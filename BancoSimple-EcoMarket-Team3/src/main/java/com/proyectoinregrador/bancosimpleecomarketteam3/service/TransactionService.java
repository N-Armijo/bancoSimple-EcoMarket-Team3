package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Transaction;

import java.util.List;

public interface TransactionService{

    Transaction findById(Long id);
    List<Transaction> findAllTransaction();
    Transaction saveTransaction(Transaction transaction);
    void deleteTransactionById(Long id);
    
}
