package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;

import java.util.List;

public interface ProductService{

    Product findById(Long id);
    List<Product> findAllProduct();
    Product saveProduct(Product product);
    void deleteProductById(Long id);

}
