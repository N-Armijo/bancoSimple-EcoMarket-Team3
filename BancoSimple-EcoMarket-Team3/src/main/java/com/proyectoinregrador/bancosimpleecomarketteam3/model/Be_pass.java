package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Be_pass")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Be_pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @OneToOne
    @JoinColumn(name = "pass_account", nullable = false)
    private Bank_account pass_Account;


}
