package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.RolRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.RolServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RolServiceTest {

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolServiceImpl rolService;

    @Test
    @DisplayName("retornaRolAlGuardar")
    void retornaRolAlGuardar(){
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setName(ERol.VENDEDOR);
        rol.setDescription("Puede realizar compras y vender sus productos");

        Rol rol2 = new Rol();
        rol2.setId(1L);
        rol2.setName(ERol.VENDEDOR);
        rol2.setDescription("Puede realizar compras y vender sus productos");

        when(rolRepository.findById(1L)).thenReturn(rol2);

        Rol result = rolRepository.findById(1L);

        assertEquals(rol.getId(), result.getId());
        assertEquals(rol.getName(), result.getName());

        System.out.println(rol);
        System.out.println(rol2);
    }
}
