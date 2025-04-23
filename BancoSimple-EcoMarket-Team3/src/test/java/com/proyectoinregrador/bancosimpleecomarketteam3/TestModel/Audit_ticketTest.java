package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Audit_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Desc_ticket;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class Audit_ticketTest {

    @Test
    void cuandoCreamosUnTicketSolicitamosLaDescripcionDelErrorPresentado(){

        Audit_ticket audit_ticket = new Audit_ticket();
        audit_ticket.setId(1L);
        audit_ticket.setAction("CREATE");
        audit_ticket.setAffected_record(1);
        LocalDate now = LocalDate.now();
        audit_ticket.setDate(now);
        audit_ticket.setDetails("some details");
        audit_ticket.setIp("192.168.1.1");
        Desc_ticket desc = new Desc_ticket();
        desc.setId(1L);
        audit_ticket.setAudit_Desc(desc);
        User user = new User();
        user.setId(1L);
        audit_ticket.setAudit_User(user);

        assertThat(audit_ticket)
                .hasFieldOrPropertyWithValue("action", "CREATE")
                .hasFieldOrPropertyWithValue("affected_record", 1)
                .hasFieldOrPropertyWithValue("details","some details")
                .hasFieldOrPropertyWithValue("ip", "192.168.1.1");
    }
}
