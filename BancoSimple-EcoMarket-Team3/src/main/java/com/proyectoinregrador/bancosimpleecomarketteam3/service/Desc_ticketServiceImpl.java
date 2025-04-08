package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Desc_ticketServiceImpl implements Desc_ticketService {

    @Override
    public Desc_ticket findById(Long id) {
        return null;
    }

    @Override
    public List<Desc_ticket> findAllDesc_ticket() {
        return List.of();
    }

    @Override
    public Desc_ticket saveDesc_ticket(Desc_ticket desc_ticket) {
        return null;
    }

    @Override
    public void deleteDesc_ticketById(Long id) {

    }
}
