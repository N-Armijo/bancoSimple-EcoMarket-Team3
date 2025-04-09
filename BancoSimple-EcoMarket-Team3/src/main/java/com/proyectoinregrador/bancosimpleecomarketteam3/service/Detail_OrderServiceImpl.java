package com.proyectoinregrador.bancosimpleecomarketteam3.service;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Detail_Order;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Detail_OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class Detail_OrderServiceImpl implements Detail_OrderService {

    private final Detail_OrderRepository detail_orderRepository;

    @Override
    public Detail_Order findById(Long id) {
        return detail_orderRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(" Detail Order not found ")
        );
    }

    @Override
    public List<Detail_Order> findAllDetail_Order() {
        return detail_orderRepository.findAll();
    }

    @Override
    public Detail_Order saveDetail_Order(Detail_Order detail_Order) {
        return detail_orderRepository.save(detail_Order);
    }

    @Override
    public void deleteDetail_OrderById(Long id) {
        detail_orderRepository.deleteById(id);
    }
}
