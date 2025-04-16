package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Desc_ticketRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Desc_ticketServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Desc_ticketServiceTest {

    @Mock
    private Desc_ticketRepository desc_ticketRepository;

    @InjectMocks
    private Desc_ticketServiceImpl desc_ticketService;


    @Test
    @DisplayName("retornaDesc_ticketAlGuardar")
    public void retornaDesc_ticketAlGuardar() {

        Desc_ticket desc_ticket = new Desc_ticket();

        desc_ticket.setId(1L);
        desc_ticket.setName("test");
        desc_ticket.setDescription("test");
        desc_ticket.setTable_reference("test");

        when(desc_ticketRepository.save(desc_ticket)).thenReturn(desc_ticket);

        Desc_ticket desc = desc_ticketService.saveDesc_ticket(desc_ticket);

        assertEquals(desc_ticket.getId(), desc.getId());
        assertEquals(desc_ticket.getName(), desc.getName());
        assertEquals(desc_ticket.getDescription(), desc.getDescription());
        assertEquals(desc_ticket.getTable_reference(), desc.getTable_reference());


    }


}
