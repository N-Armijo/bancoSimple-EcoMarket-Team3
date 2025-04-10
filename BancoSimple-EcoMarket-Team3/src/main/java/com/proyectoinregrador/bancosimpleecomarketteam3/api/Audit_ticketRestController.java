package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Audit_ticketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class Audit_ticketRestController {

    private final Audit_ticketServiceImpl audit_ticketService;

    @GetMapping("/ticket/{id}")
    public Audit_ticket findById(@PathVariable Long id){
        return audit_ticketService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Audit_ticket>> findAllAudit_Ticket(){
        return ResponseEntity.ok(audit_ticketService.findAllAudit_ticket());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Audit_ticket> saveAudit_ticket(@RequestBody Audit_ticket newTicket){
        return new ResponseEntity<>(audit_ticketService.saveAudit_ticket(newTicket), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAudit_ticketById(@PathVariable Long id){
        return new ResponseEntity<>("The Ticket was deleated",HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Audit_ticket> updateAudit_ticketById(@PathVariable Long id, @RequestBody Audit_ticket ticketEdited){
        Audit_ticket audit_ticketSelected = audit_ticketService.findById(id);
        audit_ticketSelected.setAction(audit_ticketSelected.getAction());
        audit_ticketSelected.setAffected_record(audit_ticketSelected.getAffected_record());
        audit_ticketSelected.setDetails(audit_ticketSelected.getDetails());
        audit_ticketSelected.setDate(audit_ticketSelected.getDate());
        audit_ticketSelected.setIp(audit_ticketSelected.getIp());
        audit_ticketService.saveAudit_ticket(audit_ticketSelected);
        return new ResponseEntity<>(audit_ticketSelected, HttpStatus.OK);
    }
}
