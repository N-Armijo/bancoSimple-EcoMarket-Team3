package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Commune")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "zip_code", nullable = false)
    private String zip_code;

    @ManyToOne
    @JoinColumn(name = "commune_region", nullable = false)
    private Region commune_Region;


}