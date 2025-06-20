package com.sistema_loja.sistema_loja.controllers;


import com.sistema_loja.sistema_loja.entities.Category;
import com.sistema_loja.sistema_loja.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    //Create
    @PostMapping("/add")
    public ResponseEntity <Category> create(@RequestBody Category Category){
        Category createdCategory = service.create(Category);

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    //GET ALL
    @GetMapping("/all")
    public ResponseEntity <List<Category>> getAll(){
        List <Category> allCategories = service.getAll();

        return ResponseEntity.ok().body(allCategories);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable long id){
        Category optionalCategory = service.getById(id);

        return ResponseEntity.ok().body(optionalCategory);
    }

    //Delete
    public ResponseEntity <Category> deleteCategory(@PathVariable long id){
        Category deletedCategory = service.getById(id);

        return ResponseEntity.ok().body(deletedCategory);
    }

    //Update
    public ResponseEntity<Category> updateCategory(@RequestBody Category Category, @PathVariable Long id){
        Category updatedCategory = service.update(Category, id);

        return ResponseEntity.ok().body(updatedCategory);

    }
}
