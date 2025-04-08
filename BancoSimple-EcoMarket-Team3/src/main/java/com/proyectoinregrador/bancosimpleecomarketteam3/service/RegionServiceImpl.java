package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    @Override
    public Region findById(Long id) {
        return null;
    }

    @Override
    public List<Region> findAllRegion() {
        return List.of();
    }

    @Override
    public Region saveRegion(Region region) {
        return null;
    }

    @Override
    public void deleteRegionById(Long id) {

    }
}
