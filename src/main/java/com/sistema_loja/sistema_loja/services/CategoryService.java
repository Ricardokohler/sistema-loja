package com.sistema_loja.sistema_loja.services;


import com.sistema_loja.sistema_loja.entities.Category;
import com.sistema_loja.sistema_loja.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;




    //CREATE
    public Category create(Category category) {

        try{
            return categoryRepository.save(category);
        } catch (RuntimeException e) {

            throw new RuntimeException(e.getMessage());
        }

    }





    //GET BY ID
    public Category getById(Long id) {
        Optional <Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()){
            return optionalCategory.get();

        } else {
            throw new RuntimeException("Id não encontrado");

        }
    }




    //GET ALL
    public List <Category> getAll() {

        return categoryRepository.findAll();
    }



    

    //Delete
    public void delete(long id) {
        Optional <Category> deletedcategory = categoryRepository.findById(id);

        if(deletedcategory.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }





    //Update
    public Category update(Category category, long id) {
        Optional<Category> oldcategory = categoryRepository.findById(id);

        if (oldcategory.isPresent()) {
            Category newCategory = oldcategory.get();

            newCategory.setName(category.getName());

            return categoryRepository.save(newCategory);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }




}
