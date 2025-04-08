package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;

@Entity
@Table(name = "Bank_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bank_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    private Integer account_number;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "bank_user", nullable = false)
    private User bank_User;


}