package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import jdk.jfr.Description;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;

@Entity
@Table(name = "Bank_account")
public class Bank_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    private Integer account_number;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    public Bank_account() {
    }

    public Bank_account(Long id, Integer number, BigDecimal balance) {
        this.id = id;
        this.account_number = number;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return account_number;
    }

    public void setNumber(Integer number) {
        this.account_number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bank_account{" +
                "id=" + id +
                ", number=" + account_number +
                ", balance=" + balance +
                '}';
    }
}