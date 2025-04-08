package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public Order_Product findById(Long id) {
        return null;
    }

    @Override
    public List<Order_Product> findAllOrder() {
        return List.of();
    }

    @Override
    public Order_Product saveOrder(Order_Product order_product) {
        return null;
    }

    @Override
    public void deleteOrderById(Long id) {

    }
}
