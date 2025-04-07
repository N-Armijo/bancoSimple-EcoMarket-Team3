package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import jdk.jfr.Description;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Bank_card")
public class Bank_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false, unique = true)
    private Integer card_number;

    @Column(name = "expiration_date", nullable = false)
    private Date expiration_date;

    @Column(name = "creation_date", nullable = false)
    private Date creation_date;

    @Column(name = "secret_number", nullable = false)
    private Integer secret_number;

    @ManyToOne
    @JoinColumn(name = "card_account", nullable = false)
    private Bank_account card_Account;

    public Bank_card() {
    }

    public Bank_card(Long id, Integer card_number, Date expiration_date, Date creation_date, Integer secret_number) {
        this.id = id;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.creation_date = creation_date;
        this.secret_number = secret_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCard_number() {
        return card_number;
    }

    public void setCard_number(Integer card_number) {
        this.card_number = card_number;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Integer getSecret_number() {
        return secret_number;
    }

    public void setSecret_number(Integer secret_number) {
        this.secret_number = secret_number;
    }

    @Override
    public String toString() {
        return "Bank_card{" +
                "id=" + id +
                ", card_number=" + card_number +
                ", expiration_date=" + expiration_date +
                ", creation_date=" + creation_date +
                ", secret_number=" + secret_number +
                '}';
    }
}