package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.ProductService;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductServiceImpl productService;


    @GetMapping("/Product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>("The Product was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product productSelected = productService.findById(product.getId());
        if(productSelected != null){
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
