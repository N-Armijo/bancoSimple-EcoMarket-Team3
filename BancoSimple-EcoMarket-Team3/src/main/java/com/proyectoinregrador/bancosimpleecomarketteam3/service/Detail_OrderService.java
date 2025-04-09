package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Detail_Order;

import java.util.List;

public interface Detail_OrderService {


    Detail_Order findById(Long id);
    List<Detail_Order> findAllDetail_Order();
    Detail_Order saveDetail_Order(Detail_Order be_pass);
    void deleteDetail_OrderById(Long id);
    
}
