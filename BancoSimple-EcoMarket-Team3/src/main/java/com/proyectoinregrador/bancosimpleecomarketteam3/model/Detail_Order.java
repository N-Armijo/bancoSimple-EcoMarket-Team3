package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Order;

import java.util.Date;

@Entity
@Table(name = "detail_order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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


}