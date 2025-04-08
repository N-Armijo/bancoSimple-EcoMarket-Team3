package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Audit_ticketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Audit_ticketServiceImpl implements Audit_ticketService {

    private final Audit_ticketRepository audit_ticketRepository;

    @Override
    public Audit_ticket findById(Long id) {
        return audit_ticketRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Ticket not found")
        );
    }

    @Override
    public List<Audit_ticket> findAllAudit_ticket() {
        return audit_ticketRepository.findAll();
    }

    @Override
    public Audit_ticket saveAudit_ticket(Audit_ticket audit_ticket) {
        return audit_ticketRepository.save(audit_ticket);
    }

    @Override
    public void deleteAudit_ticketById(Long id) {
        audit_ticketRepository.deleteById(id);
    }
}
