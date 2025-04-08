package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;

import java.util.List;

public interface RegionService{

    Region findById(Long id);
    List< Region> findAllRegion();
    Region saveRegion(Region region);
    void deleteRegionById(Long id);
}
