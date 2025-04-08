package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;

import java.util.List;

public interface CommuneService{

    Commune findById(Long id);
    List<Commune> findAllCommune();
    Commune saveCommune(Commune commune);
    void deleteCommuneById(Long id);

}
