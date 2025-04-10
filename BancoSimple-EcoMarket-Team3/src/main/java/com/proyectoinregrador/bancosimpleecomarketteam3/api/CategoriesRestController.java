package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.CategoriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoriesRestController {

    private final CategoriesServiceImpl categoriesService;

    @GetMapping("/{id}")
    public ResponseEntity<Categories> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriesService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Categories>> findAllCategories() {
        return ResponseEntity.ok(categoriesService.findAllCategories());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Categories> saveCategory(@RequestBody Categories newCategory) {
        return new ResponseEntity<>(categoriesService.saveCategories(newCategory), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategoriesById(id);
        return new ResponseEntity<>("The category was deleted", HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories editedCategory) {
        Categories selectedCategory = categoriesService.findById(id);
        selectedCategory.setNombre(editedCategory.getNombre());
        selectedCategory.setDescription(editedCategory.getDescription());
        return new ResponseEntity<>(categoriesService.saveCategories(selectedCategory), HttpStatus.OK);
    }
}
