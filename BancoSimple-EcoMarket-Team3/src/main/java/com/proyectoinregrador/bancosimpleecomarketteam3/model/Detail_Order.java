package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import org.hibernate.query.Order;

import java.util.Date;

@Entity
@Table(name = "detail_order")
public class Detail_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ammount", nullable = false)
    private Integer ammount;

    @Column(name = "unit_price", nullable = false)
    private Integer unit_price;

    @ManyToOne
    @JoinColumn(name = "detail_product", nullable = false)
    private Product detail_Product;

    @ManyToOne
    @JoinColumn(name = "detail_order", nullable = false)
    private Order_Product detail_Order;

    public Detail_Order() {
    }

    public Detail_Order(Long id, Integer ammount, Integer unit_price, Product detail_Product, Order_Product detail_Order) {
        this.id = id;
        this.ammount = ammount;
        this.unit_price = unit_price;
        this.detail_Product = detail_Product;
        this.detail_Order = detail_Order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Product getDetail_Product() {
        return detail_Product;
    }

    public void setDetail_Product(Product detail_Product) {
        this.detail_Product = detail_Product;
    }

    public Order_Product getDetail_Order() {
        return detail_Order;
    }

    public void setDetail_Order(Order_Product detail_Order) {
        this.detail_Order = detail_Order;
    }

    @Override
    public String toString() {
        return "Detail_Order{" +
                "id=" + id +
                ", ammount=" + ammount +
                ", unit_price=" + unit_price +
                ", detail_Product=" + detail_Product +
                ", detail_Order=" + detail_Order +
                '}';
    }
}