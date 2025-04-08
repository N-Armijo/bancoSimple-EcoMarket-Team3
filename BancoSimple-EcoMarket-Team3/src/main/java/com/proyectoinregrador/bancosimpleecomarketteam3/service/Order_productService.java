package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;

import java.util.List;

public interface Order_productService {
    Order_product findById(Long id);
    List<Order_product> findAllOrder();
    Order_product saveOrder(Order_product order_product);
    void deleteOrderById(Long id);
}
