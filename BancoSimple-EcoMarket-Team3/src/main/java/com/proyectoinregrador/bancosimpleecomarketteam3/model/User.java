package com.proyectoinregrador.bancosimpleecomarketteam3.model;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
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

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "registration_date", nullable = false, unique = true)
    private Date registration_date;

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

    public User() {
    }

    public User(Long id, String name, String email, String password, Date birthday, Date registration_date, String phone_number, Country user_Country, List<Rol> userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.registration_date = registration_date;
        this.phone_number = phone_number;
        this.user_Country = user_Country;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Country getUser_Country() {
        return user_Country;
    }

    public void setUser_Country(Country user_Country) {
        this.user_Country = user_Country;
    }

    public List<Rol> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<Rol> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", registration_date=" + registration_date +
                ", phone_number='" + phone_number + '\'' +
                ", user_Country=" + user_Country +
                ", userRole=" + userRole +
                '}';
    }
}