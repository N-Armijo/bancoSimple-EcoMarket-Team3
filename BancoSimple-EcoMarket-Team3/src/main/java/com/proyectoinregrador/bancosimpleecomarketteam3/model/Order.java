package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direction_alias", nullable = false)
    private String direction_alias;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "state", nullable = false)
    private String state;

    public Order() {
    }

    public Order(Long id, String direction_alias, Date fecha, Integer total, String state) {
        this.id = id;
        this.direction_alias = direction_alias;
        this.fecha = fecha;
        this.total = total;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection_alias() {
        return direction_alias;
    }

    public void setDirection_alias(String direction_alias) {
        this.direction_alias = direction_alias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", direction_alias='" + direction_alias + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                ", state='" + state + '\'' +
                '}';
    }
}