package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.CategoriesRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CategoriesServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoriesServiceTest {

    @Mock
    private CategoriesRepository categoriesRepository;


    @InjectMocks
    private CategoriesServiceImpl categoriesService;


    @Test
    @DisplayName("retornaCategoriesAlGuardar")
    void retornaCategoriesAlGuardar(){

        Categories categories = new Categories();

        categories.setId(1L);
        categories.setNombre("Test");
        categories.setDescription("Test Description");


        when(categoriesRepository.save(categories)).thenReturn(categories);
        Categories cat = categoriesService.saveCategories(categories);

        assertEquals(categories.getId(), cat.getId());
        assertEquals(categories.getNombre(), cat.getNombre());
        assertEquals(categories.getDescription(), cat.getDescription());

    }



}
