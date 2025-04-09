package com.proyectoinregrador.bancosimpleecomarketteam3.api;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Region;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.RegionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/regions")
public class RegionRestController {
    
    private final RegionServiceImpl regionService;


    @GetMapping("/Region/{id}")
    public Region getRegion(@PathVariable Long id) {
        return regionService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Region>> findAll(){
        return ResponseEntity.ok(regionService.findAllRegion());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Region> addRegion(@RequestBody Region region){
        return new ResponseEntity<>(regionService.saveRegion(region), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable Long id){
        return new ResponseEntity<>("The Region was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Region> updateRegion(@RequestBody Region region){
        Region regionSelected = regionService.findById(region.getId());
        if(regionSelected != null){
            return new ResponseEntity<>(regionService.saveRegion(region), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}
