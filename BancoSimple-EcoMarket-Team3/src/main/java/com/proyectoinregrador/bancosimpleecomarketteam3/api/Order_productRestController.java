package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Order_productServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderproducts")
public class Order_productRestController {
    private final Order_productServiceImpl order_productService;

    @GetMapping("/orderproduct/{id}")
    public Order_product getOrder_product(@PathVariable Long id) {
        return order_productService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order_product>> findAll(){
        return ResponseEntity.ok(order_productService.findAllOrder());
    }

    @PostMapping("/new")
    public ResponseEntity<Order_product> addOrder_product(@RequestBody Order_product order_product){
        return new ResponseEntity<>(order_productService.saveOrder(order_product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder_product(@PathVariable Long id){
        order_productService.deleteOrderById(id);
        return new ResponseEntity<>("The Order_product was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Order_product> updateOrder_product(@RequestBody Order_product order_product){
        Order_product order_productSelected = order_productService.findById(order_product.getId());
        if(order_productSelected != null){
            return new ResponseEntity<>(order_productService.saveOrder(order_product), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
