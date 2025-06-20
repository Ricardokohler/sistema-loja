package com.sistema_loja.sistema_loja.services;


import com.sistema_loja.sistema_loja.entities.Product;
import com.sistema_loja.sistema_loja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;





    //CREATE
    public Product create(Product Product) {

        try{
            return repository.save(Product);
        } catch (RuntimeException e) {

            throw new RuntimeException(e.getMessage());
        }

    }





    //GET BY ID
    public Product getById(Long id) {
        Optional <Product> optionalProduct = repository.findById(id);

        if (optionalProduct.isPresent()){
            return optionalProduct.get();

        } else {
            throw new RuntimeException("Id não encontrado");

        }
    }




    //GET ALL
    public List <Product> getAll() {

        return repository.findAll();
    }



    

    //Delete
    public void delete(long id) {
        Optional <Product> deletedProduct = repository.findById(id);

        if(deletedProduct.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }





    //Update
    public Product update(Product Product, long id) {
        Optional<Product> oldProduct = repository.findById(id);

        if (oldProduct.isPresent()) {
            Product newProduct = oldProduct.get();

            newProduct.setName(Product.getName());
            newProduct.setDescription(Product.getDescription());
            newProduct.setPrice(Product.getPrice());
            newProduct.setImgUrl(Product.getImgUrl());

            return repository.save(newProduct);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }




}
