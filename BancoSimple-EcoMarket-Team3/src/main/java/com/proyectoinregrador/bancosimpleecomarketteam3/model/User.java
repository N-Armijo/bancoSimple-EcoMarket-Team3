package com.proyectoinregrador.bancosimpleecomarketteam3.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "registration_date", nullable = false, unique = true)
    private LocalDate registration_date;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "user_country", nullable = false)
    private Country user_Country;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> userRole;


}