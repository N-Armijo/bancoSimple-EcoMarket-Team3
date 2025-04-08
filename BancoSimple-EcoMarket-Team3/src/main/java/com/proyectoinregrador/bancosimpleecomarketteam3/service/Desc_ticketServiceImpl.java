package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Desc_ticketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Desc_ticketServiceImpl implements Desc_ticketService {

    private final Desc_ticketRepository desc_ticketRepository;

    @Override
    public Desc_ticket findById(Long id) {
        return desc_ticketRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Desc_ticket not found")
        );
    }

    @Override
    public List<Desc_ticket> findAllDesc_ticket() {
        return desc_ticketRepository.findAll();
    }

    @Override
    public Desc_ticket saveDesc_ticket(Desc_ticket Desc_ticket) {
        return desc_ticketRepository.save(Desc_ticket);
    }

    @Override
    public void deleteDesc_ticketById(Long id) {
        desc_ticketRepository.deleteById(id);
    }
}
