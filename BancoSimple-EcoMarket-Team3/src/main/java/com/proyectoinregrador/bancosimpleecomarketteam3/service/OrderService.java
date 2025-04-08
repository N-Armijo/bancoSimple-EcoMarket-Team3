package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_Product;

import java.util.List;

public interface OrderService{
    Order_Product findById(Long id);
    List<Order_Product> findAllOrder();
    Order_Product saveOrder(Order_Product order_product);
    void deleteOrderById(Long id);
}
