package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Direction")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "home", nullable = false)
    private Boolean home;

    @Column(name = "creation_date", nullable = false)
    private Date creation_date;

    public Direction() {
    }

    public Direction(Long id, String alias, String street, Integer number, String department, Boolean home, Date creation_date) {
        this.id = id;
        this.alias = alias;
        this.street = street;
        this.number = number;
        this.department = department;
        this.home = home;
        this.creation_date = creation_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getHome() {
        return home;
    }

    public void setHome(Boolean home) {
        this.home = home;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", department='" + department + '\'' +
                ", home=" + home +
                ", creation_date=" + creation_date +
                '}';
    }
}