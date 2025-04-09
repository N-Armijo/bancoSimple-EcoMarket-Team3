package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Be_pass;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Be_passServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/be-pass")
public class Be_passRestController {

    private final Be_passServiceImpl bePassService;

    @GetMapping("/pass/{id}")
    public ResponseEntity<Be_pass> findById(@PathVariable Long id){
        return ResponseEntity.ok(bePassService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Be_pass>> findAllBePasses(){
        return ResponseEntity.ok(bePassService.findAllBePasses());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Be_pass> saveBePass(@RequestBody Be_pass newPass){
        return new ResponseEntity<>(bePassService.saveBePass(newPass), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBePass(@PathVariable Long id){
        bePassService.deleteBePassById(id);
        return new ResponseEntity<>("The BE Pass was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Be_pass> updateBePass(@PathVariable Long id, @RequestBody Be_pass editedPass){
        Be_pass selectedPass = bePassService.findById(id);
        selectedPass.setPassword(editedPass.getPassword());
        selectedPass.setPass_Account(editedPass.getPass_Account());
        return new ResponseEntity<>(bePassService.saveBePass(selectedPass), HttpStatus.OK);
    }
}
