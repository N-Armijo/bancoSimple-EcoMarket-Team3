package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    @Override
    public Rol findById(Long id) {
        return null;
    }

    @Override
    public List<Rol> findAllRol() {
        return List.of();
    }

    @Override
    public Rol saveRol(Rol rol) {
        return null;
    }

    @Override
    public void deleteRolById(Long id) {

    }
}
