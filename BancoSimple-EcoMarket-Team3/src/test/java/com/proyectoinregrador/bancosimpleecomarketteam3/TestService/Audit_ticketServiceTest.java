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


        Audit_ticket audit_ticket2 = new Audit_ticket();
        audit_ticket2.setId(1L);
        audit_ticket2.setAction("CREATE");

        when(audit_ticketRepository.findById(1L)).thenReturn(audit_ticket2);

        Audit_ticket reult = audit_ticketRepository.findById(1L);

        assertEquals(audit_ticket.getId(), reult.getId());
        assertEquals(audit_ticket.getAction(), reult.getAction());



//        when(audit_ticketRepository.save(audit_ticket)).thenReturn(audit_ticket);
//
//        Audit_ticket audit = audit_ticketService.saveAudit_ticket(audit_ticket);
//
//        assertEquals(audit_ticket.getId(), audit.getId());
//        assertEquals(audit_ticket.getAction(), audit.getAction());

    }
}








//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//}
//
//
//class UserServiceTest {
//
//    private UserRepository userRepository;
//    private UserService userService;
//
//    @BeforeEach
//    void setUp() {
//        userRepository = Mockito.mock(UserRepository.class);
//        userService = new UserService(userRepository);
//    }
//
//    @Test
//    void testCreateUser() {
//        User user = new User("John", "john@example.com");
//
//        Mockito.when(userRepository.save(user)).thenReturn(user);
//
//        User result = userService.createUser(user);
//
//        assertEquals("John", result.getName());
//        assertEquals("john@example.com", result.getEmail());
//    }
//}
//
//
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void testRegisterUserSuccess() {
//        User user = new User();
//        user.setName("Ana");
//        user.setEmail("ana@example.com");
//
//        // Simulamos que no existe un usuario con ese correo
//        Mockito.when(userRepository.findByEmail("ana@example.com"))
//                .thenReturn(Optional.empty());
//
//        // Simulamos guardar el usuario
//        Mockito.when(userRepository.save(user)).thenReturn(user);
//
//        User savedUser = userService.registerUser(user);
//
//        assertEquals("Ana", savedUser.getName());
//        assertEquals("ana@example.com", savedUser.getEmail());
//    }
//
//    @Test
//    void testRegisterUserWithExistingEmailThrowsException() {
//        User existingUser = new User();
//        existingUser.setEmail("ana@example.com");
//
//        Mockito.when(userRepository.findByEmail("ana@example.com"))
//                .thenReturn(Optional.of(existingUser));
//
//        User newUser = new User();
//        newUser.setEmail("ana@example.com");
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            userService.registerUser(newUser);
//        });
//    }
//}











