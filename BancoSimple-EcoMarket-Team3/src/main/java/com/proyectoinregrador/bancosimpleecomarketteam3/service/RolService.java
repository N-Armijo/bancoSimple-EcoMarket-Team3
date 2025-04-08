package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;

import java.util.List;

public interface RolService{

    Rol findById(Long id);
    List<Rol> findAllRol();
    Rol saveRol(Rol rol);
    void deleteRolById(Long id);
}
