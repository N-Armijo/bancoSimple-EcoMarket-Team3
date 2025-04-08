package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Be_pass;

import java.util.List;

public interface Be_passService{
    
    Be_pass findById(Long id);
    List<Be_pass> findAllBe_pass();
    Be_pass saveBe_pass(Be_pass be_pass);
    void deleteBe_passById(Long id);

}
