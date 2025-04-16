package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Audit_ticketRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Audit_ticketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Audit_ticketServiceTest {


    @Mock
    private Audit_ticketRepository audit_ticketRepository;

    @InjectMocks
    private Audit_ticketServiceImpl audit_ticketService;

    @Test
    @DisplayName("retornaAudit_ticketAlGuardar")
    void retornaAudit_ticketAlGuardar(){

        Audit_ticket audit_ticket = new Audit_ticket();
        audit_ticket.setId(1L);
        audit_ticket.setAction("CREATE");
        audit_ticket.setAffected_record(1);
        LocalDate now = LocalDate.now();
        audit_ticket.setDate(now);
        audit_ticket.setDetails("some details");
        audit_ticket.setIp("192.168.1.1");
        Desc_ticket desc = new Desc_ticket();;
        desc.setId(1L);
        audit_ticket.setAudit_Desc(desc);
        User user = new User();
        user.setId(1L);
        audit_ticket.setAudit_User(user);

        when(audit_ticketRepository.save(audit_ticket)).thenReturn(audit_ticket);

        Audit_ticket audit = audit_ticketService.saveAudit_ticket(audit_ticket);

        assertEquals(audit_ticket.getId(), audit.getId());
        assertEquals(audit_ticket.getAction(), audit.getAction());

    }



    @Test
    @DisplayName("retornaAudit_ticketAlBuscarPorID")
    void retornaAudit_ticketAlBuscarPorID(){

        Audit_ticket audit_ticket = new Audit_ticket();
        audit_ticket.setId(1L);
        audit_ticket.setAction("CREATE");
        audit_ticket.setAffected_record(1);
        LocalDate now = LocalDate.now();
        audit_ticket.setDate(now);
        audit_ticket.setDetails("some details");
        audit_ticket.setIp("192.168.1.1");
        Desc_ticket desc = new Desc_ticket();;
        desc.setId(1L);
        audit_ticket.setAudit_Desc(desc);
        User user = new User();
        user.setId(1L);
        audit_ticket.setAudit_User(user);


        Audit_ticket audit_ticket2 = new Audit_ticket();
        audit_ticket2.setId(1L);
        audit_ticket2.setAction("CREATE");

        when(audit_ticketRepository.findById(1L)).thenReturn(audit_ticket2);

        Audit_ticket reult = audit_ticketRepository.findById(1L);

        assertEquals(audit_ticket.getId(), reult.getId());
        assertEquals(audit_ticket.getAction(), reult.getAction());



    }
}



