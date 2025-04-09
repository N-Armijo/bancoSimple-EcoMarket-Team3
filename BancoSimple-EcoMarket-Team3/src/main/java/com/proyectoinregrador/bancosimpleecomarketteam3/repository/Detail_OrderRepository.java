package com.proyectoinregrador.bancosimpleecomarketteam3.repository;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Detail_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detail_OrderRepository extends JpaRepository<Detail_Order, Long> {

}
