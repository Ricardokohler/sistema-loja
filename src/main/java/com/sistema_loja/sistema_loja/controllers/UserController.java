package com.sistema_loja.sistema_loja.controllers;


import com.sistema_loja.sistema_loja.entities.User;
import com.sistema_loja.sistema_loja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //Create
    @PostMapping("/add")
    public ResponseEntity <User> create(@RequestBody User User){
        User createdUser = service.create(User);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //GET ALL
    @GetMapping("/all")
    public ResponseEntity <List<User>> getAll(){
        List <User> allUsers = service.getAll();

        return ResponseEntity.ok().body(allUsers);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable long id){
        User optionalUser = service.getById(id);

        return ResponseEntity.ok().body(optionalUser);
    }

    //Delete
    public ResponseEntity <User> deleteUser(@PathVariable long id){
        User deletedUser = service.getById(id);

        return ResponseEntity.ok().body(deletedUser);
    }

    //Update
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        User updatedUser = service.update(user, id);

        return ResponseEntity.ok().body(updatedUser);

    }
}
