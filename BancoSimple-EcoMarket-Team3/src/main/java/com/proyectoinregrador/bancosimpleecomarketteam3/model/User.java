package com.proyectoinregrador.bancosimpleecomarketteam3.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERol userRole;
    @Schema(example = "2000-04-04")
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @CreationTimestamp
    @Column(name = "registration_date", nullable = true)
    private LocalDate registration_date;

    @Column(name = "phone_number", nullable = true, unique = true)
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "user_country", nullable = true)
    private Country user_Country;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> userRoles;


}