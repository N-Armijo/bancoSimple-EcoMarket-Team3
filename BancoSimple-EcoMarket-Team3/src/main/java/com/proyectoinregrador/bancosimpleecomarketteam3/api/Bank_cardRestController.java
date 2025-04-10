package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_card;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Bank_cardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class Bank_cardRestController {

    private final Bank_cardServiceImpl bankCardService;

    @GetMapping("/card/{id}")
    public ResponseEntity<Bank_card> findById(@PathVariable Long id){
        return ResponseEntity.ok(bankCardService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Bank_card>> findAllBankCards(){
        return ResponseEntity.ok(bankCardService.findAllBank_card());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Bank_card> saveBankCard(@RequestBody Bank_card newCard){
        return new ResponseEntity<>(bankCardService.saveBank_card(newCard), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBankCard(@PathVariable Long id){
        bankCardService.deleteBank_cardById(id);
        return new ResponseEntity<>("The Bank Card was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Bank_card> updateBankCard(@PathVariable Long id, @RequestBody Bank_card editedCard){
        Bank_card selectedCard = bankCardService.findById(id);
        selectedCard.setCard_number(editedCard.getCard_number());
        selectedCard.setExpiration_date(editedCard.getExpiration_date());
        selectedCard.setCreation_date(editedCard.getCreation_date());
        selectedCard.setSecret_number(editedCard.getSecret_number());
        selectedCard.setCard_Account(editedCard.getCard_Account());
        return new ResponseEntity<>(bankCardService.saveBank_card(selectedCard), HttpStatus.OK);
    }
}
