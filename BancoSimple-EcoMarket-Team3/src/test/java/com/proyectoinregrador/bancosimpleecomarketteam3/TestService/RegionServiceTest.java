package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Country;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.RegionRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.RegionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegionServiceTest {

    @Mock
    private RegionRepository regionRepository;

    @InjectMocks
    private RegionServiceImpl regionService;

    @Test
    @DisplayName("retornaRegionAlGuardar")
    void retornaRegionAlGuardar() {

        Region region = new Region();
        Country country = new Country();
        country.setId(1L);

        region.setId(1L);
        region.setName("Test");
        region.setRegion_Country(country);

        when(regionRepository.save(region)).thenReturn(region);
        Region region2 = regionService.saveRegion(region);

        assertEquals(region.getId(), region2.getId());
        assertEquals(region.getName(), region2.getName());
        assertEquals(region.getRegion_Country().getId(), region2.getRegion_Country().getId());




    }




}
