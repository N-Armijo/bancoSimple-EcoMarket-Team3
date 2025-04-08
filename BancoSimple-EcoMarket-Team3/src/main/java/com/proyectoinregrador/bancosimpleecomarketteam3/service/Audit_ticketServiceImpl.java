package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Audit_ticketServiceImpl implements Audit_ticketService {


    @Override
    public Audit_ticket findById(Long id) {
        return null;
    }

    @Override
    public List<Audit_ticket> findAllAudit_ticket() {
        return List.of();
    }

    @Override
    public Audit_ticket saveAudit_ticket(Audit_ticket audit_ticket) {
        return null;
    }

    @Override
    public void deleteAudit_ticketById(Long id) {

    }
}
