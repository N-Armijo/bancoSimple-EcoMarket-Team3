package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Desc_ticket")
public class Desc_ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "table_reference", nullable = false)
    private String table_reference;

    public Desc_ticket() {
    }

    public Desc_ticket(Long id, String name, String description, String table_reference) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.table_reference = table_reference;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTable_reference() {
        return table_reference;
    }

    public void setTable_reference(String table_reference) {
        this.table_reference = table_reference;
    }

    @Override
    public String toString() {
        return "Desc_ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", table_reference='" + table_reference + '\'' +
                '}';
    }
}