package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;

import java.util.List;

public interface Audit_ticketService{

    Audit_ticket findById(Long id);
    List<Audit_ticket> findAllAudit_ticket();
    Audit_ticket saveAudit_ticket(Audit_ticket audit_ticket);
    void deleteAudit_ticketById(Long id);

}
