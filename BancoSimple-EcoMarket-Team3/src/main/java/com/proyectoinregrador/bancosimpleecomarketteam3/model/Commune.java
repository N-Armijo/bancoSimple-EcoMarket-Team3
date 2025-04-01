package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Commune")
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "zip_code", nullable = false)
    private String zip_code;

    public Commune() {
    }

    public Commune(Long id, String name, String zip_code) {
        this.id = id;
        this.name = name;
        this.zip_code = zip_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "Commune{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}