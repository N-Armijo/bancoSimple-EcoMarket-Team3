package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Direction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "home", nullable = false)
    private Boolean home;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "creation_date", nullable = false)
    private LocalDate creation_date;

    @ManyToOne
    @JoinColumn(name = "direction_user", nullable = false)
    private User direction_User;

    @ManyToOne
    @JoinColumn(name = "direction_commune", nullable = false)
    private Commune direction_Commune;


}