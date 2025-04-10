package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Commune;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CommuneServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/communes")
public class CommuneRestController {

    private final CommuneServiceImpl communeService;

    @GetMapping("/{id}")
    public ResponseEntity<Commune> findById(@PathVariable Long id) {
        return ResponseEntity.ok(communeService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Commune>> findAllCommunes() {
        return ResponseEntity.ok(communeService.findAllCommune());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Commune> saveCommune(@RequestBody Commune newCommune) {
        return new ResponseEntity<>(communeService.saveCommune(newCommune), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCommune(@PathVariable Long id) {
        communeService.deleteCommuneById(id);
        return new ResponseEntity<>("The commune was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Commune> updateCommune(@PathVariable Long id, @RequestBody Commune editedCommune) {
        Commune selectedCommune = communeService.findById(id);
        selectedCommune.setName(editedCommune.getName());
        selectedCommune.setZip_code(editedCommune.getZip_code());
        selectedCommune.setCommune_Region(editedCommune.getCommune_Region());
        return new ResponseEntity<>(communeService.saveCommune(selectedCommune), HttpStatus.OK);
    }
}
