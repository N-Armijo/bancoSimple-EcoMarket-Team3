package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
