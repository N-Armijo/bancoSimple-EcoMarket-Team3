package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService{

    Rol findById(Long id);
    Optional<Rol> findByName(ERol name);
    List<Rol> findAllRol();
    Rol saveRol(Rol rol);
    void deleteRolById(Long id);
}
