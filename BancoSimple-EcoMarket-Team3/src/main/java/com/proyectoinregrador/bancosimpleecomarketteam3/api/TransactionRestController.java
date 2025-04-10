package com.proyectoinregrador.bancosimpleecomarketteam3.api;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Transaction;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionRestController {

    
    private final TransactionServiceImpl transactionService;

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Transaction>> findAll(){
        return ResponseEntity.ok(transactionService.findAllTransaction());
    }

    @PostMapping("/new")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransactionById(id);
        return new ResponseEntity<>("The Transaction was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction){
        Transaction transactionSelected = transactionService.findById(transaction.getId());
        if(transactionSelected != null){
            return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
