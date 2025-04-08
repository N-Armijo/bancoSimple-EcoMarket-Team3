package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;

import java.util.List;

public interface Desc_ticketService{

    Desc_ticket findById(Long id);
    List<Desc_ticket> findAllDesc_ticket();
    Desc_ticket saveDesc_ticket(Desc_ticket desc_ticket);
    void deleteDesc_ticketById(Long id);

}
