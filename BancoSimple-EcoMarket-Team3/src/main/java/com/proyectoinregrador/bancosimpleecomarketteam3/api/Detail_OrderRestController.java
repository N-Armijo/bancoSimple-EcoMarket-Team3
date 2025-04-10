package com.proyectoinregrador.bancosimpleecomarketteam3.api;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Detail_Order;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Detail_OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detailorders")
public class Detail_OrderRestController {

    private final Detail_OrderServiceImpl detail_orderService;

    @GetMapping("/detailorder/{id}")
    public Detail_Order getDetail_Order(@PathVariable Long id) {
        return detail_orderService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Detail_Order>> findAll(){
        return ResponseEntity.ok(detail_orderService.findAllDetail_Order());
    }

    @PostMapping("/new")
    public ResponseEntity<Detail_Order> addDetail_Order(@RequestBody Detail_Order detail_order){
        return new ResponseEntity<>(detail_orderService.saveDetail_Order(detail_order), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDetail_Order(@PathVariable Long id){
        detail_orderService.deleteDetail_OrderById(id);
        return new ResponseEntity<>("The Detail_Order was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Detail_Order> updateDetail_Order(@RequestBody Detail_Order detail_order){
        Detail_Order detail_orderSelected = detail_orderService.findById(detail_order.getId());
        if(detail_orderSelected != null){
            return new ResponseEntity<>(detail_orderService.saveDetail_Order(detail_order), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
