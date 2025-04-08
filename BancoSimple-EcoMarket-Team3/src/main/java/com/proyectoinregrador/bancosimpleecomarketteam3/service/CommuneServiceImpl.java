package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommuneServiceImpl implements CommuneService{

    @Override
    public Commune findById(Long id) {
        return null;
    }

    @Override
    public List<Commune> findAllCommune() {
        return List.of();
    }

    @Override
    public Commune saveCommune(Commune commune) {
        return null;
    }

    @Override
    public void deleteCommuneById(Long id) {

    }
}
