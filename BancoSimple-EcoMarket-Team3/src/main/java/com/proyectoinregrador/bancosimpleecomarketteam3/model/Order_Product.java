package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "order_Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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


}
