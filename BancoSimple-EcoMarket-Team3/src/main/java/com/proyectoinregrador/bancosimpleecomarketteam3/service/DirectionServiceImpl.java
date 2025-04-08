package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Direction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {

    @Override
    public Direction findById(Long id) {
        return null;
    }

    @Override
    public List<Direction> findAllDirection() {
        return List.of();
    }

    @Override
    public Direction saveDirection(Direction direction) {
        return null;
    }

    @Override
    public void deleteDirectionById(Long id) {

    }
}
