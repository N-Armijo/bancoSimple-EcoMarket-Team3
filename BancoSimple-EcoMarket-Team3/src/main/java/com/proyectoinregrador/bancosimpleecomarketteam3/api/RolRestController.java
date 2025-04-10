package com.proyectoinregrador.bancosimpleecomarketteam3.api;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.RolServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rols")
public class RolRestController {

    private final RolServiceImpl rolService;


    @GetMapping("/rol/{id}")
    public Rol getRol(@PathVariable Long id) {
        return rolService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Rol>> findAll(){
        return ResponseEntity.ok(rolService.findAllRol());
    }

    @PostMapping("/new")
    public ResponseEntity<Rol> addRol(@RequestBody Rol rol){
        return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Long id){
        rolService.deleteRolById(id);
        return new ResponseEntity<>("The Rol was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol){
        Rol RolSelected = rolService.findById(rol.getId());
        if(RolSelected != null){
            return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
