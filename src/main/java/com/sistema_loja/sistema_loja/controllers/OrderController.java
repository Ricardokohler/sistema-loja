package com.sistema_loja.sistema_loja.controllers;


import com.sistema_loja.sistema_loja.entities.Order;
import com.sistema_loja.sistema_loja.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    //Create
    @PostMapping("/add")
    public ResponseEntity <Order> create(@RequestBody Order Order){
        Order createdOrder = service.create(Order);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    //GET ALL
    @GetMapping("/all")
    public ResponseEntity <List<Order>> getAll(){
        List <Order> allOrders = service.getAll();

        return ResponseEntity.ok().body(allOrders);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable long id){
        Order optionalOrder = service.getById(id);

        return ResponseEntity.ok().body(optionalOrder);
    }

    //Delete
    public ResponseEntity <Order> deleteOrder(@PathVariable long id){
        Order deletedOrder = service.getById(id);

        return ResponseEntity.ok().body(deletedOrder);
    }

    //Update
    public ResponseEntity<Order> updateOrder(@RequestBody Order Order, @PathVariable Long id){
        Order updatedOrder = service.update(Order, id);

        return ResponseEntity.ok().body(updatedOrder);

    }
}
