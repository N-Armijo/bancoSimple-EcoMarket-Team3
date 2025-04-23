package com.proyectoinregrador.bancosimpleecomarketteam3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String product_name;

    @NotBlank
    private String description;

    @Positive
    private Integer price;

    @PositiveOrZero
    private Integer stock;

    private String imagen;

    @NotNull
    private Long user_id;

    @NotNull
    private List<Long> categories_id;
}