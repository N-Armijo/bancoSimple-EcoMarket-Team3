package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Direction;

import java.util.List;

public interface DirectionService{

    Direction findById(Long id);
    List<Direction> findAllDirection();
    Direction saveDirection(Direction direction);
    void deleteDirectionById(Long id);


}
