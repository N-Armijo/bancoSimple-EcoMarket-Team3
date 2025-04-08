package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Region")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_country", nullable = false)
    private Country region_Country;


}