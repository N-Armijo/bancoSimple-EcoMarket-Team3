package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Be_pass")
public class Be_pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    public Be_pass() {
    }

    public Be_pass(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Be_pass{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
