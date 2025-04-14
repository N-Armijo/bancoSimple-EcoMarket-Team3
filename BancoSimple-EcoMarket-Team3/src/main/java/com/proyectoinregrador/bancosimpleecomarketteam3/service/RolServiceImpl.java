package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.RolRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public Optional<Rol> findRolByEmail(ERol name){
        return rolRepository.findByName(name);
    }

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Rol not found")
        );
    }

    @Override
    public Optional<Rol> findByName(ERol name) {
        return rolRepository.findByName(name);
    }

    @Override
    public List<Rol> findAllRol() {
        return rolRepository.findAll();
    }

    @Override
    public Rol saveRol(Rol Rol) {
        return rolRepository.save(Rol);
    }

    @Override
    public void deleteRolById(Long id) {
        rolRepository.deleteById(id);
    }
}
