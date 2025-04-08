package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Country")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iso", nullable = false, unique = true)
    private String iso;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nationality", nullable = false, unique = true)
    private String nationality;


}