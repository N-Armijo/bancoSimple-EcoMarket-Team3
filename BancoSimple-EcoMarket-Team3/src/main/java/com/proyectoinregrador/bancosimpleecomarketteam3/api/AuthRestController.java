package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.dto.LoginDTO;
import com.proyectoinregrador.bancosimpleecomarketteam3.dto.SignupDTO;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.ERol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Rol;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.security.JwtUtils;
import com.proyectoinregrador.bancosimpleecomarketteam3.security.UserDetailsImpl;
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

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateJwtToken(userDetails);

        return new ResponseEntity<>(new JwtResponse(
                jwtToken,
                userDetails.getUsername(),
                userDetails.getEmail(),
                (List<GrantedAuthority>) userDetails.getAuthorities()),
                HttpStatus.OK);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO solicitudRegistro) {
        if (userService.existUserByEmail(solicitudRegistro.getEmail())) {
            return ResponseEntity.badRequest().body("Error: el email ya está en uso.");
        }

        // Construir usuario con campos obligatorios
        User user = User.builder()
                .name(solicitudRegistro.getName())
                .email(solicitudRegistro.getEmail())
                .password(passwordEncoder.encode(solicitudRegistro.getPassword()))
                .registration_date(LocalDate.now())
                .build();

        // Campos opcionales
        if (solicitudRegistro.getPhone_number() != null && !solicitudRegistro.getPhone_number().isEmpty()) {
            if (userService.existUserByPhoneNumber(solicitudRegistro.getPhone_number())) {
                return ResponseEntity.badRequest().body("Error: el número de teléfono ya está en uso.");
            }
            user.setPhone_number(solicitudRegistro.getPhone_number());
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

        user.setUserRoles(roles);
        user.setUserRole(roles.get(0).getName());
        userService.saveUser(user);

        return ResponseEntity.ok("Usuario registrado exitosamente!");
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
