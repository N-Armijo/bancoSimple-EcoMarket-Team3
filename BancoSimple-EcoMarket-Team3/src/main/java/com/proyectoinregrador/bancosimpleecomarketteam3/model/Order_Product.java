package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "order_Product")
public class Order_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direction_alias", nullable = false)
    private String direction_alias;

    @Column(name = "dateP", nullable = false)
    private Date dateP;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "state", nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "order_user", nullable = false)
    private User order_User;

    @ManyToOne
    @JoinColumn(name = "order_account", nullable = false)
    private Bank_account order_Account;

    public Order_Product() {
    }

    public Order_Product(Long id, String direction_alias, Date dateP, Integer total, String state, User order_User, Bank_account order_Account) {
        this.id = id;
        this.direction_alias = direction_alias;
        this.dateP = dateP;
        this.total = total;
        this.state = state;
        this.order_User = order_User;
        this.order_Account = order_Account;
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

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
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

    public User getOrder_User() {
        return order_User;
    }

    public void setOrder_User(User order_User) {
        this.order_User = order_User;
    }

    public Bank_account getOrder_Account() {
        return order_Account;
    }

    public void setOrder_Account(Bank_account order_Account) {
        this.order_Account = order_Account;
    }

    @Override
    public String toString() {
        return "Order_Product{" +
                "id=" + id +
                ", direction_alias='" + direction_alias + '\'' +
                ", dateP=" + dateP +
                ", total=" + total +
                ", state='" + state + '\'' +
                ", order_User=" + order_User +
                ", order_Account=" + order_Account +
                '}';
    }
}
