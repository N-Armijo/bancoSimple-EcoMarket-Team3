package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Direction;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.DirectionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;

    @Override
    public Direction findById(Long id) {
        return directionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Direction not found")
        );
    }

    @Override
    public List<Direction> findAllDirection() {
        return directionRepository.findAll();
    }

    @Override
    public Direction saveDirection(Direction Direction) {
        return directionRepository.save(Direction);
    }

    @Override
    public void deleteDirectionById(Long id) {
        directionRepository.deleteById(id);
    }
}
