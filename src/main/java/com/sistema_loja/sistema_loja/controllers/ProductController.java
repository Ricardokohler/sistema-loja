package com.sistema_loja.sistema_loja.controllers;


import com.sistema_loja.sistema_loja.entities.Product;
import com.sistema_loja.sistema_loja.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    //Create
    @PostMapping("/add")
    public ResponseEntity <Product> create(@RequestBody Product Product){
        Product createdProduct = service.create(Product);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //GET ALL
    @GetMapping("/all")
    public ResponseEntity <List<Product>> getAll(){
        List <Product> allProducts = service.getAll();

        return ResponseEntity.ok().body(allProducts);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable long id){
        Product optionalProduct = service.getById(id);

        return ResponseEntity.ok().body(optionalProduct);
    }

    //Delete
    public ResponseEntity <Product> deleteProduct(@PathVariable long id){
        Product deletedProduct = service.getById(id);

        return ResponseEntity.ok().body(deletedProduct);
    }

    //Update
    public ResponseEntity<Product> updateProduct(@RequestBody Product Product, @PathVariable Long id){
        Product updatedProduct = service.update(Product, id);

        return ResponseEntity.ok().body(updatedProduct);

    }
}
