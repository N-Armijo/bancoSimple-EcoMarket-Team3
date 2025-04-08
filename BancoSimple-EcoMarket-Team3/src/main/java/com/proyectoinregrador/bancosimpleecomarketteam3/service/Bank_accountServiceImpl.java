package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Bank_accountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Bank_accountServiceImpl implements Bank_accountService {
    
    private final Bank_accountRepository bank_accountRepository;

    @Override
    public Bank_account findById(Long id) {
        return bank_accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Bank_account not found")
        );
    }

    @Override
    public List<Bank_account> findAllBank_account() {
        return bank_accountRepository.findAll();
    }

    @Override
    public Bank_account saveBank_account(Bank_account Bank_account) {
        return bank_accountRepository.save(Bank_account);
    }

    @Override
    public void deleteBank_accountById(Long id) {
        bank_accountRepository.deleteById(id);
    }
}
