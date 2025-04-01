package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iso", nullable = false, unique = true)
    private String iso;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nationality", nullable = false, unique = true)
    private String nationality;

    public Country() {
    }

    public Country(Long id, String iso, String name, String nationality) {
        this.id = id;
        this.iso = iso;
        this.name = name;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", iso='" + iso + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}