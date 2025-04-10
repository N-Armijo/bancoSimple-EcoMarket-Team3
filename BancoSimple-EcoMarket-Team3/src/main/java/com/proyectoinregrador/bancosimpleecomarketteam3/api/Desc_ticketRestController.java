package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Desc_ticketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/desctickets")
public class Desc_ticketRestController {

    private final Desc_ticketServiceImpl desc_ticketService;

    @GetMapping("descticket/{id}")
    public ResponseEntity<Desc_ticket> findById(@PathVariable Long id) {
        return ResponseEntity.ok(desc_ticketService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Desc_ticket>> findAllDescTickets() {
        return ResponseEntity.ok(desc_ticketService.findAllDesc_ticket());
    }

    @PostMapping("/new")
    public ResponseEntity<Desc_ticket> saveDescTicket(@RequestBody Desc_ticket newDescTicket) {
        return new ResponseEntity<>(desc_ticketService.saveDesc_ticket(newDescTicket), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDescTicket(@PathVariable Long id) {
        desc_ticketService.deleteDesc_ticketById(id);
        return new ResponseEntity<>("The ticket was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Desc_ticket> updateDescTicket(@PathVariable Long id, @RequestBody Desc_ticket editedDescTicket) {
        Desc_ticket selectedDescTicket = desc_ticketService.findById(id);
        selectedDescTicket.setName(editedDescTicket.getName());
        selectedDescTicket.setDescription(editedDescTicket.getDescription());
        selectedDescTicket.setTable_reference(editedDescTicket.getTable_reference());
        return new ResponseEntity<>(desc_ticketService.saveDesc_ticket(selectedDescTicket), HttpStatus.OK);
    }
}
