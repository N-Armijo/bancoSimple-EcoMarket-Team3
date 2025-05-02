package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.dto.LoginDTO;
import com.proyectoinregrador.bancosimpleecomarketteam3.dto.SignupDTO;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.*;
import com.proyectoinregrador.bancosimpleecomarketteam3.security.JwtUtils;
import com.proyectoinregrador.bancosimpleecomarketteam3.security.UserDetailsImpl;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Bank_accountServiceImpl;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.RolService;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.UserServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Random;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthRestController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final RolService rolService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final Bank_accountServiceImpl bankAccountService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateJwtToken(userDetails);
        User user = userService.findByEmail(loginRequest.getEmail());
        if( (user.getUserRole().equals(ERol.COMPRADOR) || user.getUserRoles().stream().equals(ERol.COMPRADOR) || user.getUserRoles().stream().anyMatch(x -> x.getName().equals(ERol.COMPRADOR) ))
                || (user.getUserRole().equals(ERol.VENDEDOR) || user.getUserRoles().stream().equals(ERol.VENDEDOR) || user.getUserRoles().stream().anyMatch(x -> x.getName().equals(ERol.VENDEDOR) ))
                || (user.getUserRole().equals(ERol.ADMIN) || user.getUserRoles().stream().equals(ERol.ADMIN) || user.getUserRoles().stream().anyMatch(x -> x.getName().equals(ERol.ADMIN) ))
        ) {
            return new ResponseEntity<>(new JwtResponse(
                    jwtToken,
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    (List<GrantedAuthority>) userDetails.getAuthorities()),
                    HttpStatus.OK);
        }


        return ResponseEntity.badRequest().body("Error: el usuario no Existe en el EcoMarket.");

    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO solicitudRegistro) {




        User exitePorGmail = userService.findByEmail(solicitudRegistro.getEmail());


        // Construir usuario con campos obligatorios
        User user = User.builder()
                .name(solicitudRegistro.getName())
                .email(solicitudRegistro.getEmail())
                .password(passwordEncoder.encode(solicitudRegistro.getPassword()))
                .registration_date(LocalDate.now())
                .build();

        if (exitePorGmail !=null) {
           if( exitePorGmail.getUserRole().equals(ERol.BANK) && !exitePorGmail.getUserRole().equals(ERol.COMPRADOR) && !exitePorGmail.getUserRole().equals(ERol.VENDEDOR) ){
               user=exitePorGmail;
           }

        }
        if (exitePorGmail !=null) {
            if(exitePorGmail.getUserRole().equals(ERol.COMPRADOR) || exitePorGmail.getUserRole().equals(ERol.VENDEDOR)){
                return ResponseEntity.badRequest().body("Error: el email ya está en uso.");
            }

        }


        // Campos opcionales
        if (solicitudRegistro.getPhone_number() != null && !solicitudRegistro.getPhone_number().isEmpty()) {
            if (userService.existUserByphoneNumber(solicitudRegistro.getPhone_number())) {
                return ResponseEntity.badRequest().body("Error: el número de teléfono ya está en uso.");
            }
            user.setPhoneNumber(solicitudRegistro.getPhone_number());
        }

        if (solicitudRegistro.getBirthday() != null) {
            user.setBirthday(solicitudRegistro.getBirthday());
        }

        // Manejo de roles
        List<String> strRol = solicitudRegistro.getRoles();
        List<Rol> roles = new ArrayList<>();

        if (strRol == null || strRol.isEmpty()) {
            Rol rolUsuario = rolService.findByName(ERol.COMPRADOR)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
            roles.add(rolUsuario);
        } else {
            strRol.forEach(role -> {
                switch (role.toUpperCase()) {
                    case "VENDEDOR":
                        Rol rolVendedor = rolService.findByName(ERol.VENDEDOR)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(rolVendedor);
                        break;
                    case "ADMIN":
                        Rol rolAdmin = rolService.findByName(ERol.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(rolAdmin);
                        break;
                    default:
                        Rol rolUsuario = rolService.findByName(ERol.COMPRADOR)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(rolUsuario);
                }
            });
        }


        //user.setUserRoles(roles);

        if(user.getUserRoles() != null){
            user.getUserRoles().addAll(roles);
        }else {
            user.setUserRoles(roles);
        }

        user.setUserRole(roles.get(0).getName());
        userService.saveUser(user);



        return ResponseEntity.ok("Usuario registrado exitosamente!");
    }

    @PostMapping("/registroBanco")
    public ResponseEntity<?> registerUserBank(@Valid @RequestBody SignupDTO solicitudRegistro) {

        Bank_account cuentaBanco = new Bank_account();
        cuentaBanco.setBalance(BigDecimal.valueOf(0.00));
        cuentaBanco.setAccount_number(Integer.valueOf(generarCuentaNumericaUnica()));
        System.out.println("Cuenta Banco: " + cuentaBanco.getAccount_number());

        User exitePorGmail = userService.findByEmail(solicitudRegistro.getEmail());
        if (exitePorGmail !=null && !exitePorGmail.getUserRole().equals(ERol.BANK) ) {

            List<Rol> roles1 = new ArrayList<>();
            roles1 =exitePorGmail.getUserRoles();


            Rol rolBank = rolService.findByName(ERol.BANK)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
            roles1.add(rolBank);

            exitePorGmail.setUserRoles(roles1);
            exitePorGmail.setUserRole(ERol.BANK);
            exitePorGmail = userService.saveUser(exitePorGmail);
            cuentaBanco.setBank_User(exitePorGmail);
            bankAccountService.saveBank_account(cuentaBanco);
            return ResponseEntity.ok("Usuario registrado exitosamente!");
        }

        // Construir usuario con campos obligatorios
        User user = User.builder()
                .name(solicitudRegistro.getName())
                .email(solicitudRegistro.getEmail())
                .password(passwordEncoder.encode(solicitudRegistro.getPassword()))
                .registration_date(LocalDate.now())
                .build();
        System.out.println("User : "+user.toString());
        // Campos opcionales
        if (solicitudRegistro.getPhone_number() != null && !solicitudRegistro.getPhone_number().isEmpty()) {
            if (userService.existUserByphoneNumber(solicitudRegistro.getPhone_number())) {
                return ResponseEntity.badRequest().body("Error: el número de teléfono ya está en uso.");
            }
            user.setPhoneNumber(solicitudRegistro.getPhone_number());
        }

        if (solicitudRegistro.getBirthday() != null) {
            user.setBirthday(solicitudRegistro.getBirthday());
        }

        // Manejo de roles
        List<String> strRol = solicitudRegistro.getRoles();
        List<Rol> roles = new ArrayList<>();
        if (strRol == null || strRol.isEmpty()) {
            Rol rolUsuario = rolService.findByName(ERol.COMPRADOR)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
            roles.add(rolUsuario);
        } else {
            strRol.forEach(role -> {
                switch (role.toUpperCase()) {
                    case "BANK":
                        Rol rolBank = rolService.findByName(ERol.BANK)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                        roles.add(rolBank);
                        break;

                }
            });
        }
        user.setUserRoles(roles);
        user.setUserRole(roles.get(0).getName());
        user = userService.saveUser(user);
        cuentaBanco.setBank_User(user);
        bankAccountService.saveBank_account(cuentaBanco);

        return ResponseEntity.ok("Usuario registrado exitosamente!");
    }

    // Genera un número de cuenta único (20 dígitos)
    public static String generarCuentaNumericaUnica() {
        long timestamp = System.currentTimeMillis();
        Random random = new Random(timestamp + System.nanoTime()); // Semilla única
        return generarCuentaNumerica(random);
    }

    // Genera un número de cuenta numérico de 20 dígitos (formato: Entidad(4) + Oficina(4) + DC(2) + Nº Cuenta(10))
    public static String generarCuentaNumerica(Random random) {
        String entidad = generarNumeroAleatorio(random, 2);       // 2 dígitos (entidad)
        String oficina = generarNumeroAleatorio(random, 2);       // 2 dígitos (oficina)
        String dc = generarNumeroAleatorio(random, 2);            // 2 dígitos (dígito de control)
        String numeroCuenta = generarNumeroAleatorio(random, 3); // 3 dígitos (número de cuenta)

        return entidad + oficina + dc + numeroCuenta; // 20 dígitos en total
    }

    // Genera un número aleatorio de longitud fija
    public static String generarNumeroAleatorio(Random random, int longitud) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append(random.nextInt(10)); // Dígitos del 0 al 9
        }
        return sb.toString();
    }

    @PostMapping("/loginBanco")
    public ResponseEntity<?> authenticateUserBank(@Valid @RequestBody LoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateJwtToken(userDetails);
        User user = userService.findByEmail(loginRequest.getEmail());
        if(user.getUserRole().equals(ERol.BANK) || user.getUserRoles().stream().equals(ERol.BANK) || user.getUserRoles().stream().anyMatch(x -> x.getName().equals(ERol.BANK) ) ) {
            return new ResponseEntity<>(new JwtResponse(
                    jwtToken,
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    (List<GrantedAuthority>) userDetails.getAuthorities()),
                    HttpStatus.OK);


        }

        return ResponseEntity.badRequest().body("Error: el usuario no Existe en el banco.");
    }



    @AllArgsConstructor
    @Getter
    @Setter
    public static class JwtResponse {
        private String token;
        private String username;
        private String email;
        private List<GrantedAuthority> roles;
    }
}
