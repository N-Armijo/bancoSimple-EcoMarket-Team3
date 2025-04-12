package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.CommuneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommuneServiceImpl implements CommuneService{

    private final CommuneRepository communeRepository;

    @Override
    public Commune findById(Long id) {
        return communeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Commune not found")
        );
    }

    @Override
    public List<Commune> findAllCommune() {
        return communeRepository.findAll();
    }

    @Override
    public Commune saveCommune(Commune Commune) {
        return communeRepository.save(Commune);
    }

    @Override
    public void deleteCommuneById(Long id) {
        communeRepository.deleteById(id);
    }
}
