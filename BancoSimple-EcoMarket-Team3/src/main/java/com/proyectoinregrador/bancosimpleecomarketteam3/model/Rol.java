package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Rol")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private ERol name;

    @Column(name = "description", nullable = false)
    private String description;


}