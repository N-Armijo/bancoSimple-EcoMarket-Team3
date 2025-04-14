package com.proyectoinregrador.bancosimpleecomarketteam3.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
