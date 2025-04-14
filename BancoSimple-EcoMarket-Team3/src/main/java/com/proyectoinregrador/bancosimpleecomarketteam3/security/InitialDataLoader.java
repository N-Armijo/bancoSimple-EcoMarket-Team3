package com.proyectoinregrador.bancosimpleecomarketteam3.security;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
public class InitialDataLoader {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        if (userService.existUserByEmail("EcoManager@gmail.com")) {
            System.out.println("Ya existe un usuario Admin");
        } else {
            User admin = User.builder()
                    .name("Administrador")
                    .email("EcoManager@gmail.com")
                    .password(passwordEncoder.encode("Admin1234"))
                    .userRole(ERol.ADMIN)
                    .birthday(LocalDate.now())
                    .build();
            userService.saveUser(admin);
        }
    }
}
