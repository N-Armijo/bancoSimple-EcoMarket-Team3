package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.CommuneRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CommuneService;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CommuneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommuneServiceTest {

    @Mock
    private CommuneRepository communeRepository;

    @InjectMocks
    private CommuneServiceImpl communeService;


    @Test
    @DisplayName("retornaCommuneGuardar")
    void retornaCommuneGuardar(){

        Commune commune = new Commune();
        Region region = new Region();

        commune.setId(1L);
        commune.setZip_code("123222");
        region.setId(1L);
        commune.setCommune_Region(region);

        when(communeRepository.save(commune)).thenReturn(commune);
        Commune comm = communeService.saveCommune(commune);

        assertEquals(commune.getId(), comm.getId());
        assertEquals(commune.getZip_code(), comm.getZip_code());
        assertEquals(commune.getCommune_Region().getId(), comm.getCommune_Region().getId());



    }

}
