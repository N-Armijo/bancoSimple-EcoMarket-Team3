package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Direction;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Desc_ticketRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.DirectionRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.DirectionService;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.DirectionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DirectionServiceTest {

    @Mock
    private DirectionRepository directionRepository;

    @InjectMocks
    private DirectionServiceImpl directionService;

    @Test
    @DisplayName("retornaDirectionAlGuardar")
    void retornaDirectionAlGuardar(){

        Direction direction = new Direction();
        User user = new User();
        Commune commune = new Commune();

        user.setId(1L);
        commune.setId(1L);

        direction.setId(1L);
        direction.setAlias("alias");
        direction.setStreet("street");
        direction.setNumber(2331);
        direction.setDepartment("department");
        direction.setHome(true);
        direction.setCreation_date(LocalDate.now());
        direction.setDirection_User(user);
        direction.setDirection_Commune(commune);


        when(directionRepository.save(direction)).thenReturn(direction);
        Direction direc = directionService.saveDirection(direction);

        assertEquals(direction.getId(), direc.getId());
        assertEquals(direction.getAlias(), direc.getAlias());
        assertEquals(direction.getStreet(), direc.getStreet());
        assertEquals(direction.getNumber(), direc.getNumber());
        assertEquals(direction.getDepartment(), direc.getDepartment());
        assertEquals(direction.getHome(), direc.getHome());
        assertEquals(direction.getCreation_date(), direc.getCreation_date());
        assertEquals(direction.getDirection_User().getId(), direc.getDirection_User().getId());
        assertEquals(direction.getDirection_Commune().getId(), direc.getDirection_Commune().getId());



    }


}
