package com.proyectoinregrador.bancosimpleecomarketteam3.repository;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findById(long id);
    Optional<Rol> findByName(ERol name);

}
