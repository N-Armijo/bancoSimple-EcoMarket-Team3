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
@Table(name = "Transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "type", nullable = false)
    private String type;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToOne
    @JoinColumn(name = "transaction_Origin", nullable = false)
    private Bank_account transaction_Origin;

    @OneToOne
    @JoinColumn(name = "transaction_destiny", nullable = false)
    private Bank_account transaction_Destiny;


}