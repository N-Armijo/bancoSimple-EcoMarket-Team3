package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Bank_accountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class Bank_accountRestController {

    private final Bank_accountServiceImpl bankAccountService;

    @GetMapping("/account/{id}")
    public ResponseEntity<Bank_account> findById(@PathVariable Long id){
        return ResponseEntity.ok(bankAccountService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Bank_account>> findAllAccounts(){
        return ResponseEntity.ok(bankAccountService.findAllBankAccounts());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Bank_account> saveAccount(@RequestBody Bank_account newAccount){
        return new ResponseEntity<>(bankAccountService.saveBankAccount(newAccount), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        bankAccountService.deleteBankAccountById(id);
        return new ResponseEntity<>("The Bank Account was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Bank_account> updateAccount(@PathVariable Long id, @RequestBody Bank_account editedAccount){
        Bank_account selectedAccount = bankAccountService.findById(id);
        selectedAccount.setAccount_number(editedAccount.getAccount_number());
        selectedAccount.setBalance(editedAccount.getBalance());
        selectedAccount.setBank_User(editedAccount.getBank_User());
        return new ResponseEntity<>(bankAccountService.saveBankAccount(selectedAccount), HttpStatus.OK);
    }
}
