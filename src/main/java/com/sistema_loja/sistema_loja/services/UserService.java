package com.sistema_loja.sistema_loja.services;


import com.sistema_loja.sistema_loja.entities.User;
import com.sistema_loja.sistema_loja.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;





    //CREATE
    public User create(User User) {

        try{
            return repository.save(User);
        } catch (RuntimeException e) {

            throw new RuntimeException(e.getMessage());
        }

    }





    //GET BY ID
    public User getById(Long id) {
        Optional <User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()){
            return optionalUser.get();

        } else {
            throw new RuntimeException("Id não encontrado");

        }
    }




    //GET ALL
    public List <User> getAll() {

        return repository.findAll();
    }





    //Delete
    public void delete(long id) {
        Optional <User> deletedUser = repository.findById(id);

        if(deletedUser.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }





    //Update
    public User update(User User, long id) {
        Optional<User> oldUser = repository.findById(id);

        if (oldUser.isPresent()) {
            User newUser = oldUser.get();

            newUser.setName(User.getName());
            newUser.setEmail(User.getEmail());
            newUser.setPhone(User.getPhone());
            newUser.setPassword(User.getPassword());

            return repository.save(newUser);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }




}
