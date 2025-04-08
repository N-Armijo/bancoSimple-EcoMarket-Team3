package com.proyectoinregrador.bancosimpleecomarketteam3.repository;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_productRepository extends JpaRepository<Order_product, Long> {

}
