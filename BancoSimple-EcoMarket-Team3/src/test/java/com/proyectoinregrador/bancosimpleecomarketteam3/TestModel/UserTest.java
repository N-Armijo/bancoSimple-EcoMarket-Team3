package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserModel() {
        Country country = new Country();
        country.setId(1L);
        country.setIso("CL");
        country.setName("Chile");
        country.setNationality("Chilena");

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setName(ERol.VENDEDOR);
        rol.setDescription("Usuario con permiso para vender productos");

        User user = User.builder()
                .id(1L)
                .name("Gabriel")
                .email("gabriel@example.com")
                .password("1234")
                .userRole(ERol.VENDEDOR)
                .birthday(LocalDate.of(2003, 5, 21))
                .registration_date(LocalDate.of(2024, 4, 16))
                .phone_number("+56912345678")
                .user_Country(country)
                .userRoles(Collections.singletonList(rol))
                .build();

        assertEquals(1L, user.getId());
        assertEquals("Gabriel", user.getName());
        assertEquals("gabriel@example.com", user.getEmail());
        assertEquals("1234", user.getPassword());
        assertEquals(ERol.VENDEDOR, user.getUserRole());
        assertEquals(LocalDate.of(2003, 5, 21), user.getBirthday());
        assertEquals(LocalDate.of(2024, 4, 16), user.getRegistration_date());
        assertEquals("+56912345678", user.getPhone_number());
        assertEquals(country, user.getUser_Country());
        assertEquals(1, user.getUserRoles().size());
        assertEquals(rol, user.getUserRoles().get(0));
    }
}
