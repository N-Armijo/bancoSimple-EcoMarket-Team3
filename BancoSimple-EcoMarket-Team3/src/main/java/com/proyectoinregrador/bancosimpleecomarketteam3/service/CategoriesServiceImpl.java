package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.CategoriesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public Categories findById(Long id) {
        return categoriesRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categories not found")
        );
    }

    @Override
    public List<Categories> findAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories saveCategories(Categories Categories) {
        return categoriesRepository.save(Categories);
    }

    @Override
    public void deleteCategoriesById(Long id) {
        categoriesRepository.deleteById(id);
    }
}
