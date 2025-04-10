package com.proyectoinregrador.bancosimpleecomarketteam3.api;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Direction;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.DirectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directions")
public class DirectionRestController {
    private final DirectionServiceImpl directionService;

    @GetMapping("/direction/{id}")
    public Direction getDirection(@PathVariable Long id) {
        return directionService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Direction>> findAll(){
        return ResponseEntity.ok(directionService.findAllDirection());
    }

    @PostMapping("/new")
    public ResponseEntity<Direction> addDirection(@RequestBody Direction direction){
        return new ResponseEntity<>(directionService.saveDirection(direction), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirection(@PathVariable Long id){
        directionService.deleteDirectionById(id);
        return new ResponseEntity<>("The Direction was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Direction> updateDirection(@RequestBody Direction direction){
        Direction directionSelected = directionService.findById(direction.getId());
        if(directionSelected != null){
            return new ResponseEntity<>(directionService.saveDirection(direction), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
