package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;

import java.util.List;

public interface CategoriesService{

    Categories findById(Long id);
    List<Categories> findAllCategories();
    Categories saveCategories(Categories categories);
    void deleteCategoriesById(Long id);


}
