package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Order_productRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Order_productServiceImpl implements Order_productService {

    private final Order_productRepository order_productRepository;

    @Override
    public Order_product findById(Long id) {
        return order_productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order not found")
        );
    }

    @Override
    public List<Order_product> findAllOrder() {
        return order_productRepository.findAll();
    }

    @Override
    public Order_product saveOrder(Order_product Order) {
        return order_productRepository.save(Order);
    }

    @Override
    public void deleteOrderById(Long id) {
        order_productRepository.deleteById(id);
    }
}
