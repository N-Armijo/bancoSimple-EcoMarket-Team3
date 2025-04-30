package com.proyectoinregrador.bancosimpleecomarketteam3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class SignupDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private List<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @Size(min = 8, max = 20)
    private String phone_number;

    private LocalDate birthday;

    private String user_Country;
}
