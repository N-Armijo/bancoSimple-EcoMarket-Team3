package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.RegionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Region not found")
        );
    }

    @Override
    public List<Region> findAllRegion() {
        return regionRepository.findAll();
    }

    @Override
    public Region saveRegion(Region Region) {
        return regionRepository.save(Region);
    }

    @Override
    public void deleteRegionById(Long id) {
        regionRepository.deleteById(id);
    }
}
