package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.*;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.UserRepository;

import com.proyectoinregrador.bancosimpleecomarketteam3.service.UserServiceImpl;

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
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("retornaUserAlGuardar")
    void retornaUserAlGuardar(){

        Country country = new Country();
        country.setId(1L);
        country.setName("Chile");

        User user = new User();
        user.setId(1L);
        user.setName("Simon");
        user.setEmail("SimonEcoMarket@gmail.com");
        user.setPassword("Simpomeron123");
        user.setUserRole(ERol.VENDEDOR);
        LocalDate now = LocalDate.now();
        user.setBirthday(LocalDate.of(2000,04,04));
        user.setRegistration_date(now);
        user.setPhone_number("+56 933420943");
        user.setUser_Country(country);

        User user2 = new User();
        user2.setId(1L);
        user2.setName("Simon");

        when(userRepository.findById(1L)).thenReturn(user2);

        User result = userRepository.findById(1L);

        assertEquals(user.getId(), result.getId());
        assertEquals(user.getName(), result.getName());

        System.out.println(user);
        System.out.println(user2);

    }
}
