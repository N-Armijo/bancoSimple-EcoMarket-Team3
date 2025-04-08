package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;

import java.util.List;

public interface UserService{
    User findById(Long id);
    List<User> findAllUser();
    User saveUser(User user);
    void deleteUserById(Long id);
}
