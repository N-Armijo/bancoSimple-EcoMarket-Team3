package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Bank_card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bank_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false, unique = true)
    private Integer card_number;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expiration_date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "creation_date", nullable = false)
    private LocalDate creation_date;

    @Column(name = "secret_number", nullable = false)
    private Integer secret_number;

    @ManyToOne
    @JoinColumn(name = "card_account", nullable = false)
    private Bank_account card_Account;


}