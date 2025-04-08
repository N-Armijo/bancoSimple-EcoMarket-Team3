package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_card;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Bank_cardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Bank_cardServiceImpl implements Bank_cardService {

    private final Bank_cardRepository bank_cardRepository;

    @Override
    public Bank_card findById(Long id) {
        return bank_cardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Bank_card not found")
        );
    }

    @Override
    public List<Bank_card> findAllBank_card() {
        return bank_cardRepository.findAll();
    }

    @Override
    public Bank_card saveBank_card(Bank_card Bank_card) {
        return bank_cardRepository.save(Bank_card);
    }

    @Override
    public void deleteBank_cardById(Long id) {
        bank_cardRepository.deleteById(id);
    }
}
