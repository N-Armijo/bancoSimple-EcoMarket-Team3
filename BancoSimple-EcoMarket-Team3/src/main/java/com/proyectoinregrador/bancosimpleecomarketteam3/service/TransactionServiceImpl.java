package com.proyectoinregrador.bancosimpleecomarketteam3.service;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Transaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {


    @Override
    public Transaction findById(Long id) {
        return null;
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return List.of();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public void deleteTransactionById(Long id) {

    }
}
