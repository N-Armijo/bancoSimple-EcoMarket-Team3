package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;

import java.util.List;

public interface UserService{


    User findById(Long id);
    User findByEmail(String email);
    Boolean existByEmail(String email);
    List<User> findAllUser();
    User saveUser(User newUser);
    void deleteUserById(Long id);
}
