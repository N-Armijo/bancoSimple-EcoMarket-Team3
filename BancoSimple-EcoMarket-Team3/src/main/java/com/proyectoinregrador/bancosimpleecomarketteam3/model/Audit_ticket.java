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
@Table(name = "Audit_ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Audit_ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action", nullable = false)
    private String Action;

    @Column(name = "affected_record", nullable = false)
    private Integer affected_record;

    @Column(name = "details", nullable = false)
    private String details;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "ip", nullable = false)
    private String ip;

    @ManyToOne
    @JoinColumn(name = "audit_User", nullable = false)
    private User audit_User;

    @ManyToOne
    @JoinColumn(name = "audit_desc", nullable = false)
    private Desc_ticket audit_Desc;

}