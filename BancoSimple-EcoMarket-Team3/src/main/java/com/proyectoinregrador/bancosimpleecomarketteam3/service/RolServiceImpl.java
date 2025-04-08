package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.RolRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Rol not found")
        );
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
